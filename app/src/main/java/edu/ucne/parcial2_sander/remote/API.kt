package edu.ucne.parcial2_sander.remote

import edu.ucne.parcial2_sander.remote.verboDTO
import retrofit2.http.GET

interface API{

    @GET("/")
    suspend fun getVerbos(): List<verboDTO>

}