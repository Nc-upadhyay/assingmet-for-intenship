package com.nc.internship_assignment.apis

import com.nc.internship_assignment.model.UserData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("photos")
     fun getPhottos(): Call<List<UserData>>
}