package com.example.smallsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv);
        dummyData()
        val clickAdapter = ClickAdapter(list)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = clickAdapter

        clickAdapter.setClickedPosition { position -> Toast.makeText(this@MainActivity, "" + position, Toast.LENGTH_SHORT).show() }
    }

    private fun dummyData() {
        for (i in 1..10){
            list.add(i.toString())
        }
    }
}