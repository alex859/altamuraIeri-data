package it.altamuraieri.data.repository

import it.altamuraieri.data.entity.Proverb
import org.springframework.stereotype.Repository

@Repository
interface ProverbRepository: org.springframework.data.repository.Repository<Proverb, Long> {
    fun save(proverb: Proverb): Proverb
    fun findAll(): Collection<Proverb>
    fun findByCode(code: String): Proverb?
}