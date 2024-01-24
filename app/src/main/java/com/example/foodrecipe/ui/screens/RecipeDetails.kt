package com.example.foodrecipe.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeDetails(){

    Column (modifier = Modifier  
    ){
      Column (modifier = Modifier){
//          Image(
//              painter = rememberAsyncImagePainter(dataModel),
//              contentDescription = null,
//              modifier = Modifier
//
//                  .size(200.dp)
//          )
          Text(
              text = " Recipe details",
              fontSize = 20.sp,
              fontWeight = FontWeight.Bold,
              fontFamily = FontFamily.Monospace,
              modifier = Modifier.padding(8.dp)
          )
      }
    }

}