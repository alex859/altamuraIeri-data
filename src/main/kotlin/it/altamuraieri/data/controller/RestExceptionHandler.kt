package it.altamuraieri.data.controller

import it.altamuraieri.data.dto.ApiError
import it.altamuraieri.data.exception.EntityNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception


@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {
    private val LOG = LoggerFactory.getLogger(RestExceptionHandler::class.java)

    @ExceptionHandler(value = EntityNotFoundException::class)
    protected fun handleEntityNotFoundException(ex: EntityNotFoundException, request: WebRequest) =
            handleExceptionInternal(apiError =  ApiError(HttpStatus.NOT_FOUND, ex.localizedMessage), exception =  ex, request =  request)

    private fun handleExceptionInternal(apiError: ApiError, exception: Exception, headers: HttpHeaders? = null, request: WebRequest) =
            handleExceptionInternal(exception, apiError, headers, apiError.status, request)

    override fun handleExceptionInternal(ex: Exception?, body: Any?, headers: HttpHeaders?, status: HttpStatus?, request: WebRequest?): ResponseEntity<Any> {
        LOG.error("Exception: [{}]", ex?.localizedMessage)
        LOG.trace("StackTrace: ", ex)
        return super.handleExceptionInternal(ex, body ?: defaultBody(status, ex), headers, status, request)
    }

    private fun defaultBody(status: HttpStatus?, ex: Exception?): ApiError =
        ApiError(status ?: HttpStatus.INTERNAL_SERVER_ERROR, ex?.localizedMessage ?: "Error processing request")


}