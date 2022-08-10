package com.danish.android.translator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danish.android.translator.data.ResponseItem
import com.danish.android.translator.network.ApiConfig
import retrofit2.Callback

class TranslatorViewModel(): ViewModel() {

    val searchWord = MutableLiveData<ResponseItem>()

    fun getDataApi(word : String){
        ApiConfig.getApiService().searchWord(word).enqueue(
            object : Callback<ArrayList<ResponseItem>>
            {
                override fun onResponse(
                    call: retrofit2.Call<ArrayList<ResponseItem>>,
                    response: retrofit2.Response<ArrayList<ResponseItem>>
                ) {
                    searchWord.value = response.body()?.get(0)
                }
                override fun onFailure(call: retrofit2.Call<ArrayList<ResponseItem>>, t: Throwable) {
                }
            }
        )
    }





}