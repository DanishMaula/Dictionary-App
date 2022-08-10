package com.danish.android.translator.network

import com.danish.android.translator.data.ResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("en/{word}")
    fun searchWord(@Path("word") word : String) : Call<ArrayList<ResponseItem>>


}