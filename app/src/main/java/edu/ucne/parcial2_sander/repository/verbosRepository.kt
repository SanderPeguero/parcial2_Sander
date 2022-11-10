package edu.ucne.parcial2_sander.repository

import edu.ucne.parcial2_sander.remote.verboDTO
import edu.ucne.parcial2_sander.remote.API

import javax.inject.Inject

class verboRepository @Inject constructor(
    private val api: API
){
    suspend fun getVerbos(): List<verboDTO> {

        val listaDto = api.getVerbos()

        return listaDto
    }

}