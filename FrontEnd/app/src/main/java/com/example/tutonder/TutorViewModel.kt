package com.example.tutonder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tutonder.network.User

class TutorViewModel : ViewModel() {
    private val responseReceived = MutableLiveData<User>()
    var nombre= ""
    var carrera= ""
    var cursos= ""
    var contacto= ""

}