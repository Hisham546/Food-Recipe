package com.example.foodrecipe.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument



@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route)
    {
        composable(route = Screens.Home.route){
           HomeScreen(navController)
        }

//        composable(route = Screens.RecipeDetails.route){
//           RecipeDetails(navController)
//        }
        composable(
            route = "${Screens.RecipeDetails.route}/{${Screens.RecipeDetails.ARG_TITLE}}",
            arguments = listOf(navArgument(Screens.RecipeDetails.ARG_TITLE) { type = NavType.StringType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val title = arguments.getString(Screens.RecipeDetails.ARG_TITLE)
            RecipeDetails(navController, title)
        }

    }
}
