package com.binjesus.apitask.Interface

import com.binjesus.apitask.model.Pet
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PetApiService {

    @GET("pets")
    suspend fun getAllPets(): List<Pet>
    @POST("pets")
    suspend fun addPet(@Body pet: Pet): Response<Pet>

    @DELETE("pets/{petID}")
    suspend fun deleteBook(@Path("petID") petID: Int): Response<Unit>
}
