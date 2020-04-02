package com.example.tutonder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val responseReceived = MutableLiveData<String>()

}