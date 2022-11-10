package edu.ucne.parcial2_sander.remote

import com.squareup.moshi.Json

data class verboDTO(
    @Json(name="Verbo")
    val Verbo: String,
    val Categoria: String,
    val Nivel: String,
    val Imagen: String
)