package com.example.smallsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var postAdapter: PostAdapter
    lateinit var layoutManager: LinearLayoutManager
    var listPost = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        postAdapter = PostAdapter(listPost)
        recyclerView.adapter = postAdapter

        fetchPost()

    }

    private fun fetchPost() {
        RetrofitClient.getRetrofitClient().post.enqueue(object : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>,
                                    response: Response<List<Post>>) {
                if (response.isSuccessful && response.body() != null){
                    response.body()?.let { listPost.addAll(it)
                        postAdapter.notifyDataSetChanged()
                    }

                }
            }

            override fun onFailure(call: Call<List<Post>>,
                                   t: Throwable) {
                Log.d(":: ","Internet issue")
            }

        })
    }
}