package com.example.foodrecipe.ui.screens

import DataModel
import android.util.Log
import android.widget.SearchView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.foodrecipe.api.ApiService
import com.example.foodrecipe.api.ApiServiceBuilder.retrofit
import com.example.foodrecipe.ui.theme.Hex1
import com.example.foodrecipe.ui.theme.Hex2
import com.example.foodrecipe.ui.theme.Hex3

@Composable

fun HomeScreen(){
    var responseData by remember { mutableStateOf<List<DataModel>?>(null) }
    val rowColors = listOf(Hex1, Hex2, Hex3) //custom colors to dynamically apply to boxes

    LaunchedEffect(key1 = true ){
    val response = retrofit.create(ApiService::class.java).fetchData()
    responseData = response.results
    Log.d("MyComposable", "Received response: $response")
}
    Column(
        modifier = Modifier

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)

        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)

            ) {

            }
            Text(
                text = "All Recipes",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                LazyRow  (

                    horizontalArrangement = Arrangement.spacedBy(8.dp) //for giving space between rows
                ) {

                    itemsIndexed(responseData.orEmpty()) { index,dataModel ->
                        val color = rowColors.getOrNull(index % rowColors.size) ?: Color.Gray
                        Box(
                            modifier = Modifier
                                .background(color = color, shape = RoundedCornerShape(10.dp))
                                .width(140.dp)
                                .height(190.dp)
                                .padding(8.dp) // Adjust padding as needed
                        ) {

                            Image(
                                painter = rememberAsyncImagePainter(dataModel.image),
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(CircleShape)

                                    .size(120.dp)
                            )
//                            Text(text = dataModel.title, color = Color.White)
                        }
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White)

        ) {
            // Add content for the second column here
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Preview(){
    HomeScreen()

}