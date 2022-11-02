package edu.ucne.parcial2_sander.repository

import edu.ucne.parcial2_sander.model.Verbo
import edu.ucne.parcial2_sander.remote.verboDTO
import edu.ucne.parcial2_sander.remote.API
import javax.inject.Inject

//val verbo: String,
//val categoria: String,
//val nivel: String,
//val imagen: String

class verboRepository @Inject constructor(
    val api: API
){
    suspend fun getVerbos() {

        val listaDto = api.getVerbos()

        val listaEntity = listaDto.map { verboDTO ->
            Verbo(
                verbo = verboDTO.verbo,
                categoria = verboDTO.categoria,
                nivel = verboDTO.nivel,
                imagen = verboDTO.imagen

            )
        }

    }
}