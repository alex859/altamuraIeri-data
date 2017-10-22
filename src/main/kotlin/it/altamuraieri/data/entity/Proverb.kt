package it.altamuraieri.data.entity

import it.altamuraieri.data.dto.ProverbDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Proverb(
        val code: String,
        val text: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,
        val translation: String? = null,
        val meaning: String? = null,
        val audioMp3: String? = null,
        val picture: String? = null

) {
    @Suppress("unused")
    private constructor() : this(code = "", text = "")

    fun toDto() = ProverbDto(this.code, this.text, this.translation, this.meaning, this.audioMp3, this.picture)

    companion object {
        fun fromDto(dto: ProverbDto) = Proverb(dto.code, dto.text, null, dto.translation, dto.meaning, dto.audioMp3, dto.picture)
    }
}
