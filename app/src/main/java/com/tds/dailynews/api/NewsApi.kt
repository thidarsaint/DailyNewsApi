package com.tds.dailynews.api

import com.tds.dailynews.model.ArticlesItem
import com.tds.dailynews.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApi{

    private val newsApiInterface: NewsApiInterface

    companion object{
        const val BASE_URL = "https://newsapi.org/v2/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsApiInterface = retrofit.create(NewsApiInterface::class.java)
    }

    fun getResults(): Call<News> {
        return newsApiInterface.getArticle("us","7579a65e3c27495aad3a5d764d4ccbc9")
    }
}