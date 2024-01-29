package com.binjesus.apitask.repositories

import com.binjesus.apitask.Interface.PetApiService

class PetRepository(private val api: PetApiService) {
    suspend fun getAllPets() = api.getAllPets()
}