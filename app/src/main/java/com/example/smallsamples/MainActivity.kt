package com.example.smallsamples

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    val tvInitial: TextView
        get() = findViewById(R.id.tv_initial)

    val btnUpdate: Button
        get() = findViewById(R.id.btn_update)

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

         mainActivityViewModel.liveData.observe(this) {
             tvInitial.text = it
         }
        btnUpdate.setOnClickListener {
            mainActivityViewModel.updateFacts()
        }
    }

}