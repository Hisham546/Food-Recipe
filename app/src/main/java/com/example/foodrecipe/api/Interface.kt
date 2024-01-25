package com.example.foodrecipe.api

import retrofit2.http.GET
import retrofit2.http.POST

//interface ApiService {
//    @GET("complexSearch")
//    suspend fun fetchData():  List<com.example.foodrecipe.api.DataModel>
//}
interface ApiService {
    @GET("complexSearch")
    suspend fun fetchData(): ApiResponse
@POST("information")
suspend fun fetchRecipeDetails(id: Int): ApiResponse
    data class ApiResponse(
        val results: List<DataModel>,
        val offset: Int,
        val number: Int
        // Add other fields as needed
    )
}