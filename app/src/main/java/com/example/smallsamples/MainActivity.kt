package com.example.smallsamples

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var rvNews: RecyclerView
    var newsList = mutableListOf<Articles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvNews = findViewById(R.id.rv_news_list)

        rvNews.adapter = NewsAdapter(this, newsList)


        getNews();

    }

    private fun getNews() {
      
        val news = NewService.newsInstance.getTopHeadlinesNews("in", "business")
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>,
                                    response: Response<News>) {
                Log.d("Fetch ::", "Successful " + response.body().toString())
                response.body()?.articles?.let { newsList.addAll(it) }
                rvNews.adapter?.notifyDataSetChanged() // rvNews.adapter = response.body()?.articles?.let { NewsAdapter(this@MainActivity, it) }
                // rvNews.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<News>,
                                   t: Throwable) {
                Log.d("Fetch ::", "Error")
            }

        })
    }
}