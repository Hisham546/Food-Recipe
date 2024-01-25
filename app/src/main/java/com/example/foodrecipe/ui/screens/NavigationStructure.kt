package com.example.foodrecipe.ui.screens

import com.example.foodrecipe.api.DataModel
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route)
    {
        composable(route = Screens.Home.route){
           HomeScreen(navController)
        }


//        composable(
//            route = "${Screens.RecipeDetails.route}/{${Screens.RecipeDetails.ARG_TITLE}}",
//            arguments = listOf(navArgument(Screens.RecipeDetails.ARG_TITLE) { type = NavType.StringType })
//        ) { backStackEntry ->
//            val arguments = requireNotNull(backStackEntry.arguments)
//            val title = arguments.getString(Screens.RecipeDetails.ARG_TITLE)
//            RecipeDetails(navController, title)
//        }

        composable(
            route = "${Screens.RecipeDetails.route}/{${Screens.RecipeDetails.ARG_DATAMODEl}}",
            arguments = listOf(navArgument(Screens.RecipeDetails.ARG_DATAMODEl) { type = NavType.StringType })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val dataModelString = arguments.getString(Screens.RecipeDetails.ARG_DATAMODEl)

            // Deserialize the com.example.foodrecipe.api.DataModel object from the string
            val dataModel: DataModel? = dataModelString?.let {
                Json.decodeFromString<DataModel>(Uri.decode(it))
            }

            if (dataModel != null) {
                RecipeDetails(navController, dataModel)
            } else {

            }
        }

    }
}
