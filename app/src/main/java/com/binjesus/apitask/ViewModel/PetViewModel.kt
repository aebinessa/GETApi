package com.binjesus.apitask.ViewModel

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binjesus.apitask.Interface.PetApiService
import com.binjesus.apitask.model.Pet
import com.binjesus.apitask.repositories.PetRepository
import com.binjesus.apitask.singelton.RetrofitHelper
import kotlinx.coroutines.launch

class PetViewModel : ViewModel() {
    private val petApiService = RetrofitHelper.getInstance().create(PetApiService::class.java)
    private val repository = PetRepository(petApiService)

    var pets by mutableStateOf(listOf<Pet>())

    init {
        fetchPets()
    }

    fun fetchPets() {
        viewModelScope.launch {
            try {
                pets = repository.getAllPets()
            } catch (e: Exception) {
                println("this is an error $e")

            }
        }
    }

    fun addPet(pet: Pet) {
        viewModelScope.launch {
            try {
                val response = petApiService.addPet(pet)
                if (response.isSuccessful && response.body() != null) {
                    // Handle successful addition of the book, e.g., updating the UI or list of books
                } else {
                    // Handle failure, e.g., showing an error message
                }
            } catch (e: Exception) {
                // Handle any exceptions, e.g., network errors
            }
        }
    }
    fun deletePet(petID: Int) {
        viewModelScope.launch {
            try {
                val response = petApiService.deleteBook(petID)
                if (response.isSuccessful) {

                } else {
                    // Handle failure, e.g., showing an error message
                }
            } catch (e: Exception) {
                // Handle any exceptions, e.g., network errors
            }
        }
    }
}


