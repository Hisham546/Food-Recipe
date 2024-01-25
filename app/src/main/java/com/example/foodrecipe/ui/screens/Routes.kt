package com.example.foodrecipe.ui.screens

//
//object Routes {
//
//    const val HOME_SCREEN = "HOME_SCREEN"
//    const val WELCOME_SCREEN = "WELCOME_SCREEN"
//
//}

sealed class Screens(val route: String) {
    object Home: Screens("home_screen")
    object Welcome: Screens("welcome_screen")


    object RecipeDetails :Screens("recipe_details/{dataModel}"){

        const val ARG_DATAMODEl = "dataModel"
    }

}