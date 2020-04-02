package com.example.tutonder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TutorViewModel : ViewModel() {
    private val responseReceived = MutableLiveData<String>()
    var nombre= ""
    var carrera= ""
    var cursos= ""
    var contacto= ""

}