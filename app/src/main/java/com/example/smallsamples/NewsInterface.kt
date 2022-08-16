package com.example.smallsamples

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * (C) Koninklijke Philips N.V., 2022.
 * All rights reserved.
 */

/* why do we need const when we have val?*/
const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "f911b0d8ef184470ba360cd095a74107"

interface NewsInterface {
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getTopHeadlinesNews(@Query("country") country: String, @Query("category") category: String): Call<News>
}

object NewService {
    val newsInstance: NewsInterface

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}