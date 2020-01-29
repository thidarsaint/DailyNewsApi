package com.tds.dailynews.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tds.dailynews.R
import com.tds.dailynews.model.ArticlesItem

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val newsImage = itemView.findViewById<ImageView>(R.id.news_image)
    val articles = itemView.findViewById<TextView>(R.id.articles_title)
    val description = itemView.findViewById<TextView>(R.id.description)
}

class NewsAdapter(var newsList : List<ArticlesItem> = ArrayList()) : RecyclerView.Adapter<NewsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.news_article, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
//        holder.articles.text = newsList[position]?.articles?.get(position)?.title.toString()
//        Glide.with(context).load(newsList[position].articles?.get(position)?.urlToImage).into(holder.newsImage)

        holder.articles.text = newsList[position].title
        holder.description.text = newsList[position].description
        Picasso.get().load(newsList[position].urlToImage)
            .placeholder(R.drawable.loadingcolor)
            .into(holder.newsImage)
    }

    fun updateList(article: List<ArticlesItem>){
        this.newsList = article
        notifyDataSetChanged()
    }



}