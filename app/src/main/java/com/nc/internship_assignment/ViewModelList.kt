package com.nc.internship_assignment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nc.internship_assignment.apis.ApiInterface
import com.nc.internship_assignment.apis.RectrofitInstance
import com.nc.internship_assignment.model.UserData
import retrofit2.Call
import retrofit2.Response

class ViewModelList : ViewModel() {
   private var listOfImage: MutableLiveData<List<UserData>> = MutableLiveData()


    fun getListOfImage(): MutableLiveData<List<UserData>> {
        return listOfImage
    }

     fun makeAPICall() {
        var apiService = RectrofitInstance().getRetrofit().create(ApiInterface::class.java)
        var call = apiService.getPhottos()
        call.enqueue(object : retrofit2.Callback<List<UserData>> {
            override fun onResponse(
                call: Call<List<UserData>>,
                response: Response<List<UserData>>
            ) {
                if (response.isSuccessful) {
                    Log.d("nc", "=================== Successful  $response")
                    listOfImage.postValue(response.body())
                    Log.d("nc","movie list=========================$listOfImage");

                } else {
                    Log.d("nc", "=================== fail  $response")
                }
            }

            override fun onFailure(call: Call<List<UserData>>, t: Throwable) {
                Log.d("nc", "=================== error  ${t.stackTrace}")
            }

        })
    }
        fun observeMovieLiveData():LiveData<List<UserData>>
        {
            return  listOfImage
        }
}