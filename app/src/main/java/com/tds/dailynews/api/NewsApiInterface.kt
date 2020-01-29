package com.tds.dailynews.api

import com.tds.dailynews.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface{

    //@Headers("X-Api-Key: 7579a65e3c27495aad3a5d764d4ccbc9")
    @GET("top-headlines")
    fun getArticle(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ):Call<News>
}