package com.tds.dailynews.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tds.dailynews.Adapter.NewsAdapter

import com.tds.dailynews.R
import com.tds.dailynews.model.News
import com.tds.dailynews.viewmodel.ArticleViewModel
import kotlinx.android.synthetic.main.fragment_news_article.*

/**
 * A simple [Fragment] subclass.
 */
class NewsArticleFragment : Fragment() {
    private lateinit var articleAdapter : NewsAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var articleViewModel: ArticleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(activity)
        articleAdapter = NewsAdapter()
        recycler_news.adapter = articleAdapter
        recycler_news.layoutManager = viewManager

        observeViewModel()
    }

    fun observeViewModel(){
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel::class.java)
        articleViewModel.getResult().observe(this, Observer<News> {result->
            recycler_news.visibility = View.VISIBLE
            articleAdapter.updateList(result?.articles!!)

        })

        articleViewModel.getError().observe(this, Observer<Boolean> {isError ->
            if(isError) {
                error_msg.visibility = View.VISIBLE
                recycler_news.visibility = View.GONE
            }else{
                error_msg.visibility = View.GONE
            }
        })

        articleViewModel.getLoading().observe(this, Observer<Boolean> {isLoading ->
            loadingView.visibility = (if(isLoading) View.VISIBLE else View.INVISIBLE)
            if(isLoading){
                error_msg.visibility = View.GONE
                recycler_news.visibility = View.GONE
            }
        })




    }

    override fun onResume() {
        super.onResume()
        articleViewModel.loadResult()
    }


}
