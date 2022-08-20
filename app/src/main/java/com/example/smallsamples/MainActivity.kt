package com.example.smallsamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.smallsamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityMainBinding: ActivityMainBinding
    lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        mainActivityMainBinding.mainViewModel = mainActivityViewModel
        mainActivityMainBinding.lifecycleOwner = this

    }
}