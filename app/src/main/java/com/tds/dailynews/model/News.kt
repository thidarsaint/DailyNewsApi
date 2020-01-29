package com.tds.dailynews.model

import com.google.gson.annotations.SerializedName

data class News(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticlesItem>?,

	@field:SerializedName("status")
	val status: String? = null
)