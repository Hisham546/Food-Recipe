package com.example.foodrecipe.api

import DataModel
import retrofit2.http.GET

//interface ApiService {
//    @GET("complexSearch")
//    suspend fun fetchData():  List<DataModel>
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