package com.example.tutonder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tutonder.network.User

class EditarViewModel : ViewModel() {
    private val responseReceived = MutableLiveData<User>()

}