package com.example.tutonder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListaViewModel : ViewModel() {
    private val responseReceived = MutableLiveData<String>()
    private var lista=ArrayList<String>()


}