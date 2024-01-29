package com.example.foodrecipe.api

import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("complexSearch")
    suspend fun fetchData(): ApiResponse
@POST("information")
suspend fun fetchRecipeDetails(id: Int): RecipeDetailsResponse
    data class ApiResponse(
        val results: List<DataModel>,
        val offset: Int,
        val number: Int
        // Add other fields as needed
    )
    data class RecipeDetailsResponse(
        val results: List<RecipeDetailsModel>,
        val offset: Int,
        val number: Int
        // Add other fields as needed
    )
}