package com.tds.dailynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tds.dailynews.Adapter.NewsAdapter
import com.tds.dailynews.api.NewsApiInterface
import com.tds.dailynews.model.ArticlesItem
import com.tds.dailynews.ui.NewsArticleFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var BASE_URL = "https://newsapi.org/v2/"

    lateinit var newsRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            val articleFragment = NewsArticleFragment()
            supportFragmentManager.beginTransaction().add(R.id.screen_container, articleFragment).commit()
        }


    }


}
