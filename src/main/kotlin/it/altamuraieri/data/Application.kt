package it.altamuraieri.data

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
@EnableWebMvc // also enables @ControllerAdvice
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
