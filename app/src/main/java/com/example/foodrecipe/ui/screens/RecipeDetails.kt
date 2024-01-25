package com.example.foodrecipe.ui.screens

import MyViewModel
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import com.example.foodrecipe.api.DataModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeDetails(navController: NavController, dataModel: DataModel?) {

    val viewModel: MyViewModel = viewModel()

    //var responseData by remember { mutableStateOf<List<DataModel>?>(null) }
    LaunchedEffect(key1 = true) {


        // Call the function in the ViewModel to fetch data
        if (dataModel != null) {
            viewModel.recipeInformationApi(dataModel.id)
        }

        // Observe the LiveData from the ViewModel
        viewModel.responseData.observeForever { data ->
            // Update the local state when the LiveData changes
           // responseData = data
            Log.d("ApiResponse...........", data.toString())
        }
    }

    Column(modifier = Modifier) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            if (dataModel != null) {
                Image(
                    painter = rememberAsyncImagePainter(dataModel.image),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .size(350.dp)
                )

                if (dataModel.title != null) {
                    Text(
                        text = dataModel.title,
                        // Other text styling properties can be added here
                        modifier = Modifier.padding(8.dp)
                    )
                }
            } else {
                // Handle the case where the com.example.foodrecipe.api.DataModel object is null
            }
        }
    }
}