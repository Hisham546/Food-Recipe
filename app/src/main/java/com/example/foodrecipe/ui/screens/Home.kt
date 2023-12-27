package com.example.foodrecipe.ui.screens

import android.util.Log
import android.widget.SearchView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.api.ApiService
import com.example.foodrecipe.api.ApiServiceBuilder.retrofit

@Composable

fun HomeScreen(){
LaunchedEffect(key1 = true ){
    val response = retrofit.create(ApiService::class.java).fetchData()
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
            Box(modifier = Modifier
                .background(color = Color.Gray, shape = RoundedCornerShape(10.dp))
                .width(140.dp)
                .height(160.dp)

            )
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