package com.example.foodrecipe.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeDetails(dataModel: String?){

    Column (modifier = Modifier  
    ){
      Column (modifier = Modifier){
          Image(
              painter = rememberAsyncImagePainter(dataModel),
              contentDescription = null,
              modifier = Modifier

                  .size(200.dp)
          )
      }
    }

}