package com.binjesus.apitask.composables
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.binjesus.apitask.ViewModel.PetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    val petViewModel: PetViewModel = viewModel()
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = { Text("My Pet List") }) }
        ,
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("addPet")}) {
                Text("+")
            }
        }
    ) { padding ->
        NavHost(navController = navController, startDestination = "petList") {
            composable("petList") {
                PetListScreen(viewModel = petViewModel, modifier = Modifier.padding(padding))
            }
            composable("addPet") {
                AddPetScreen(petViewModel = petViewModel)

            }
        }
    }
}

