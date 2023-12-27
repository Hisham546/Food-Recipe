package com.example.foodrecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodrecipe.ui.screens.HomeScreen
import com.example.foodrecipe.ui.screens.NavigationStructure
import com.example.foodrecipe.ui.screens.Routes
import com.example.foodrecipe.ui.theme.FoodRecipeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodRecipeTheme {
              NavigationStructure()
            }
        }
    }
}

