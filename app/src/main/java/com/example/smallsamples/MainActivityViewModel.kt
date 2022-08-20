package com.example.smallsamples

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * (C) Koninklijke Philips N.V., 2022.
 * All rights reserved.
 */
class MainActivityViewModel: ViewModel() {

    private val factMutuableLiveData = MutableLiveData<String>("This is the initial value")
    public val liveData : LiveData<String>
    get() = factMutuableLiveData

    fun updateFacts(){
        factMutuableLiveData.value = "Hurry New facts"
    }

}