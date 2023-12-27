package com.example.foodrecipe.api

import retrofit2.http.GET

interface ApiService {
    @GET("complexSearch")
    suspend fun fetchData():  List<DataModel>
}