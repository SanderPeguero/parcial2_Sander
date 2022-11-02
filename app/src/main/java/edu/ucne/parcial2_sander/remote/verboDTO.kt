package edu.ucne.parcial2_sander.remote

import com.squareup.moshi.Json

data class verboDTO(
    @Json(name="Verbos")
    val verbo: String,
    val categoria: String,
    val nivel: String,
    val imagen: String
)