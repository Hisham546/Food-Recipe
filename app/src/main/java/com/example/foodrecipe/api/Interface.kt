package com.example.foodrecipe.api

import retrofit2.http.GET

//interface ApiService {
//    @GET("complexSearch")
//    suspend fun fetchData():  List<com.example.foodrecipe.api.DataModel>
//}
interface ApiService {
    @GET("complexSearch")
    suspend fun fetchData(): ApiResponse

    data class ApiResponse(
        val results: List<DataModel>,
        val offset: Int,
        val number: Int
        // Add other fields as needed
    )
}