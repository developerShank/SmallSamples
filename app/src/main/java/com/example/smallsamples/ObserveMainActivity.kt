package com.example.smallsamples

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * (C) Koninklijke Philips N.V., 2022.
 * All rights reserved.
 */
class ObserveMainActivity : LifecycleObserver {

    fun registerLifeCycleObserver(lifecycle: Lifecycle) {
        lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner,
                                        event: Lifecycle.Event) {
                when (event) {
                    Lifecycle.Event.ON_CREATE -> onCreate()
                    Lifecycle.Event.ON_START -> onStart()
                    Lifecycle.Event.ON_RESUME -> onResume()
                    Lifecycle.Event.ON_PAUSE -> pause()
                    Lifecycle.Event.ON_STOP -> stop()
                    Lifecycle.Event.ON_DESTROY -> onDestroy()
                    else -> {}
                }
            }
        })
    }


    fun onCreate() {
        Log.d("Main ", "ON_Create")
    }

    fun onStart() {
        Log.d("Main ", "on_Start: ")
    }

    fun onResume() {
        Log.d("Main ", "ON_RESUME")
    }

    fun pause() {
        Log.d("Main ", "ON_PAUSE")
    }

    fun stop() {
        Log.d("Main ", "ON_STOP ")
    }

    fun onDestroy(){
        Log.d("Main", "ON_DESTROY ")
    }

}