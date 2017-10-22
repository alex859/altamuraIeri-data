package it.altamuraieri.data.service.impl

import it.altamuraieri.data.dto.ProverbDto
import it.altamuraieri.data.entity.Proverb
import it.altamuraieri.data.exception.ProverbEntityNotFoundException
import it.altamuraieri.data.repository.ProverbRepository
import it.altamuraieri.data.service.ProverbService

class DefaultProverbService(private val repository: ProverbRepository) : ProverbService {
    override fun readByCode(code: String): ProverbDto? =
            repository.findByCode(code)?.toDto() ?: throw ProverbEntityNotFoundException("Unable to find Proverb with code $code")

    override fun readAll(): Collection<ProverbDto> = repository.findAll().map { it.toDto() }

    override fun save(proverb: ProverbDto) {
        repository.save(Proverb.fromDto(proverb))
    }
}