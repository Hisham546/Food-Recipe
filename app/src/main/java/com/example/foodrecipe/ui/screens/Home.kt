package com.example.foodrecipe.ui.screens

import DataModel
import MyViewModel
import android.util.Log
import android.widget.SearchView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.flow.collect
import com.example.foodrecipe.ui.theme.Hex1
import com.example.foodrecipe.ui.theme.Hex2
import com.example.foodrecipe.ui.theme.Hex3

@Composable

fun HomeScreen(navController: NavController){
    val viewModel: MyViewModel = viewModel()
    val rowColors = listOf(Hex1, Hex2, Hex3) //custom colors to dynamically apply to boxes


// Local mutable state to hold the response data
    var responseData by remember { mutableStateOf<List<DataModel>?>(null) }

    LaunchedEffect(key1 = true) {


        // Call the function in the ViewModel to fetch data
        viewModel.fetchDataFromApi()

        // Observe the LiveData from the ViewModel
        viewModel.responseData.observeForever { data ->
            // Update the local state when the LiveData changes
            responseData = data
        }
    }

    // Update the local state when the LiveData changes
    responseData = viewModel.responseData.value
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
                fontFamily = FontFamily.Monospace,
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
                                .width(145.dp)
                                .height(210.dp)
                                .padding(8.dp)
                                .clickable {
                                    // Navigate to another screen when the Box is clicked


                                    navController.navigate("${Screens.RecipeDetails.route}/${dataModel.title}") {
                                        launchSingleTop = true
                                    }

                                }
                        ) {

                            Image(
                                painter = rememberAsyncImagePainter(dataModel.image),
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(30.dp))


                                    .size(120.dp)
                            )
                           Text(text = dataModel.title,
                               color = Color.Black,
                               fontSize = 13.sp,
                               fontWeight = FontWeight.Medium,
                               fontFamily = FontFamily.Serif,
                               modifier = Modifier
                                   .align(Alignment.BottomCenter)

                               )
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

