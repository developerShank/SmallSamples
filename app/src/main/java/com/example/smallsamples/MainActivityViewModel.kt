package com.example.smallsamples

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * (C) Koninklijke Philips N.V., 2022.
 * All rights reserved.
 */
class MainActivityViewModel : ViewModel() {
    val quoteLiveData = MutableLiveData<String>("This is an initial quote")

    fun updateQuote() {
        quoteLiveData.value = "Another quote, Hurry!!"
    }
}