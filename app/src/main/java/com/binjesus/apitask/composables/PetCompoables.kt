package com.binjesus.apitask.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.binjesus.apitask.ViewModel.PetViewModel
import com.binjesus.apitask.model.Pet

@Composable
fun PetListScreen(viewModel: PetViewModel = viewModel(), modifier: Modifier = Modifier) {
    val pets = viewModel.pets
    LazyColumn(modifier = modifier) {
        items(pets) { pet ->
            PetItem(pet, viewModel)
        }
    }
}

@Composable
fun PetItem(pet: Pet, petViewModel : PetViewModel = viewModel()) {
    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .shadow(10.dp, shape = RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Cyan)
    ) {
        Row(
            Modifier
                .padding(10.dp)
                .height(150.dp),
            verticalAlignment = Alignment.CenterVertically
            ) {
            AsyncImage(
                model = pet.image,
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
            )
            Spacer(modifier = Modifier.padding(30.dp))
            Column() {

                Text(text = "Name: ${pet.name}",fontSize = 15.sp,
                    fontWeight = FontWeight.Bold)
                Text(text = "Gender: ${pet.gender}",fontSize = 15.sp,
                    fontWeight = FontWeight.Bold)
                Text(text = "ID: ${pet.id}",fontSize = 15.sp,
                    fontWeight = FontWeight.Bold)
                Text(text = "Age: ${pet.age}",fontSize = 15.sp,
                    fontWeight = FontWeight.Bold)
                Text(text = "Adopted: ${pet.adopted.toString()}",fontSize = 15.sp,
                    fontWeight = FontWeight.Bold)


            }

            }
        Button(onClick = {
            petViewModel.deletePet(pet.id)
            petViewModel.fetchPets()
        }) {
            Text("Delete")
        }
    }
}

