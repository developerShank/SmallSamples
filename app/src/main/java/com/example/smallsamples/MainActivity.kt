package com.example.smallsamples

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*


/**/
class MainActivity : AppCompatActivity() {
    lateinit var tvCounter: TextView
    var TAG = "KotlinSample "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvCounter = findViewById(R.id.tv_counter)
        Log.d(TAG, Thread.currentThread().name)
        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }

        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }

    }



    /* 3. Coroutine
    * 1- Suspend
    * 2- yield
    * 3.delay(milliseconds)
    * */

    suspend fun task1() {
        Log.d(TAG, "Task 1 Started ${Thread.currentThread().name}")
        yield()
        Log.d(TAG, "Task 1 Ended  ${Thread.currentThread().name}")
    }


    suspend fun task2() {
        Log.d(TAG, "Task 2 Started ${Thread.currentThread().name}")
        delay(10000)
        Log.d(TAG, "Task 2 Ended  ${Thread.currentThread().name}")
    }



    /*2. Coroutine
    * 1. Coroutine Scope - LifeTime (It define the life time of the coroutine)
    * 2. Coroutine Context - Threads (In thread this coroutine is going to execute)
    *
    * Dispatchers
    * Its a kind of thread pool
    * Dispatcher defines the thread on which coroutine with work on.
    * Predefined Dispatcher:
    * 1. Dispatcher.IO
    * 2. Dispatcher.Main
    * 3. Dispatcher.default
    * */
    fun updateCounter(view: View) {
        val counter = tvCounter.text.toString().toInt() + 1
        tvCounter.text = "$counter"
        Log.d(TAG , Thread.currentThread().name)
    }

    fun doAction(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG, "Thread Started :: 1 - ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Thread Started :: 2 - ${Thread.currentThread().name}")
        }

        MainScope().launch(Dispatchers.Default) {
            Log.d(TAG, "Thread Started :: 3 - ${Thread.currentThread().name}")
        }
    }

    private fun executeThisTask() {
        Log.d(TAG, "Thread Started :: ${Thread.currentThread().name}")
        for (i in 1..100000L) {

        }
        Log.d(TAG, "Thread Stopped :: ${Thread.currentThread().name}")
    }




/*
* 1. Normal thread
* Where we are delegating the work to thread in background
* Uncomment the below to see the normal thread execution
* */
  /*  fun updateCounter(view: View) {
        var counter = tvCounter.text.toString().toInt() + 1
        tvCounter.text = "$counter"
        Log.d(TAG , Thread.currentThread().name)
    }

    fun doAction(view: View) {
        thread(start = true) {
            executeThisTask()
        }
    }

    private fun executeThisTask() {
        Log.d(TAG, "Thread Started :: ${Thread.currentThread().name}")
        for (i in 1..100000L) {

        }
        Log.d(TAG, "Thread Stopped :: ${Thread.currentThread().name}")
    }*/
}