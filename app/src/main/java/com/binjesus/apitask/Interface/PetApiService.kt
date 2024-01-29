package com.binjesus.apitask.Interface

import com.binjesus.apitask.model.Pet
import retrofit2.http.GET

interface PetApiService {

    @GET("pets")
    suspend fun getAllPets(): List<Pet>
}