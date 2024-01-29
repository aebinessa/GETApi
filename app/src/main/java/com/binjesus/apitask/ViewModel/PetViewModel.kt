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
}


