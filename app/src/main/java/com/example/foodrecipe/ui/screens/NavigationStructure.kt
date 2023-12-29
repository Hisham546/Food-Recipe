package com.example.foodrecipe.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationStructure(){

    //navhost is used to pass the screen
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN ){

        composable(Routes.HOME_SCREEN){
            HomeScreen(navController)
        }
        composable("recipeDetails") { RecipeDetails() }
    }
}

