package com.tds.dailynews.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tds.dailynews.api.NewsApi
import com.tds.dailynews.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleViewModel : ViewModel(){
    var results: MutableLiveData<News> = MutableLiveData()                     //if you want to change data, use mutable live data

    var articleLoadError: MutableLiveData<Boolean> = MutableLiveData()

    var loading: MutableLiveData<Boolean> = MutableLiveData()

    fun getResult(): LiveData<News> = results

    fun getError(): LiveData<Boolean> = articleLoadError

    fun getLoading(): LiveData<Boolean> = loading

    private val newsApi : NewsApi = NewsApi()

    fun loadResult(){
        loading.value = true
        val call = newsApi.getResults()

        Log.d("call", call.toString())
        call.enqueue(object : Callback<News>{
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("failed", t.toString())
                articleLoadError.value = true
                loading.value = false
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                Log.d("success", "success")
                response.isSuccessful.let {
                    loading.value = false
                    var resultList = response.body()!!
                    results.value = resultList
                }
            }

        })
    }


}