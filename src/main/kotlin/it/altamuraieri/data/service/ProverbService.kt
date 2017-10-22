package it.altamuraieri.data.service

import it.altamuraieri.data.dto.ProverbDto

interface ProverbService {
    fun readByCode(code: String): ProverbDto?
    fun readAll(): Collection<ProverbDto>
    fun save(proverb: ProverbDto)
}