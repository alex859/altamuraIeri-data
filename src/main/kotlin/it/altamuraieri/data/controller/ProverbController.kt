package it.altamuraieri.data.controller

import it.altamuraieri.data.dto.ProverbDto
import it.altamuraieri.data.service.ProverbService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/proverbs")
class ProverbController(private val proverbService: ProverbService) {

    init {
        proverbService.save(ProverbDto("P1", "Text1"))
        proverbService.save(ProverbDto("P2", "Text2"))
    }

    @GetMapping("/")
    fun getAllProverbs() = proverbService.readAll()

    @GetMapping("/{code}")
    fun getByCode(@PathVariable code: String) = proverbService.readByCode(code)
}