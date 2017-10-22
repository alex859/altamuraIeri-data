package it.altamuraieri.data.dto

class ProverbDto(val code: String,
                 val text: String,
                 val translation: String? = null,
                 val meaning: String? = null,
                 val audioMp3: String? = null,
                 val picture: String? = null)