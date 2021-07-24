package com.codingwithrufat.deliveryapptest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelMain : ViewModel() {

    private val TAG = "ViewModelMain"

    var data: MutableLiveData<List<ResultsItem?>?> = MutableLiveData()

    fun getData(): LiveData<List<ResultsItem?>?> {
        return data
    }

//    fun setDataRequest() {
//
//        var data: MutableLiveData<List<com.codingwithrufat.deliveryapptest.ResultsItem?>?> = MutableLiveData()
//        var api: com.codingwithrufat.deliveryapptest.IApi = ApiClient.getRetrofit()!!.create(com.codingwithrufat.deliveryapptest.IApi::class.java)
//        var apiCall: Call<List<com.codingwithrufat.deliveryapptest.ResultsItem>> =
//            api.getFoodInformations("pasta", "1", "64fb3e15382e4e9392adde24f23e0e9a")
//        apiCall.enqueue(object : Callback<List<com.codingwithrufat.deliveryapptest.ResultsItem>> {
//            override fun onResponse(
//                call: Call<List<com.codingwithrufat.deliveryapptest.ResultsItem>>,
//                response: Response<List<com.codingwithrufat.deliveryapptest.ResultsItem>>
//            ) {
//                if (response.isSuccessful) {
//                    data.value = response.body()
//                    Log.d(TAG, "onResponse: Api Gelir")
//                }
//            }
//
//            override fun onFailure(call: Call<List<com.codingwithrufat.deliveryapptest.ResultsItem>>, t: Throwable) {
//                Log.d(TAG, "onResponse: Api Gelmir")
//            }
//
//        })
//
//    }

    fun getDeliveryData(){

        val api = ApiClient.getRetrofit()!!.create(IApi::class.java)
        val apiCall = api.getFoodInformations("pasta", "0", "64fb3e15382e4e9392adde24f23e0e9a")
        apiCall.enqueue(object : Callback<ComplexResponse> {
            override fun onResponse(
                call: Call<ComplexResponse>,
                response: Response<ComplexResponse>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()!!.results
                    Log.d(TAG, "onResponse: Data successfully comes")
                }
            }

            override fun onFailure(call: Call<ComplexResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: Data doesn't come --- ${t.message}")
            }

        })
    }

}