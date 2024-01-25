package com.example.foodrecipe.ui.screens

import com.example.foodrecipe.api.DataModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RecipeDetails(navController: NavController, dataModel: DataModel?) {
    Column(modifier = Modifier) {
        Column(modifier = Modifier) {

            if (dataModel != null) {
//                Image(
//                    painter = rememberAsyncImagePainter(dataModel.image),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(30.dp))
//                        .size(120.dp)
//                )

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