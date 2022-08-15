package com.example.smallsamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songsList = ArrayList<Songs>();
        songsList.add(Songs("Hotline Bling","Hotline Bing"))
        songsList.add(Songs("What Do You Mean?","Justin Bieber"))
        songsList.add(Songs("Watch Me","Watch Me"))
        songsList.add(Songs("679","Remy Boyz"))
        songsList.add(Songs("Can't Feel My Face","The Weeknd"))
        songsList.add(Songs("Good for You","Selena Gomez ft"))
        songsList.add(Songs("If You","Big Bang"))
        songsList.add(Songs("Sorateiden kuningas","Teuvo, maanteiden kuningas"))
        songsList.add(Songs("Hurjakuru","Juhana"))
        songsList.add(Songs("Matti","Awak"))
        songsList.add(Songs("Matti","Awak"))
        songsList.add(Songs("Matti","Awak"))
        songsList.add(Songs("Matti","Awak"))
        songsList.add(Songs("Matti","Awak"))
        songsList.add(Songs("Matti","Awak"))

        val rv = findViewById<RecyclerView>(R.id.rv_songs)
        rv.adapter = MyAdapter(songsList)
        rv.layoutManager = LinearLayoutManager(this)

    }
}