package com.nc.internship_assignment.apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RectrofitInstance {
   private var baseUrl = "https://jsonplaceholder.typicode.com/"
 private   lateinit var retrofit: Retrofit
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}