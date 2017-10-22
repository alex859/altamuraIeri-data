package it.altamuraieri.data.configuration

import it.altamuraieri.data.repository.ProverbRepository
import it.altamuraieri.data.service.impl.DefaultProverbService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ServiceConfig {
    @Bean
    fun proverbService(proverbRepository: ProverbRepository) = DefaultProverbService(proverbRepository)
}