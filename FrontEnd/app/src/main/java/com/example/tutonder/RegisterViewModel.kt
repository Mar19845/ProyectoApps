package com.example.tutonder

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tutonder.network.User

class RegisterViewModel: ViewModel() {
    private val responseReceived = MutableLiveData<User>()
    var carne=""
    var nombre=""
    var carrera=""
    var contacto=""
    var password1=""
    var password2=""

    private lateinit var wordList: MutableList<String>

    fun getText(id:String, nom:String, carr:String, cont:String, pass1:String, pass2:String){
        carne=id
        nombre=nom
        carrera=carr
        contacto = cont
        password1 = pass1
        password2 = pass2
    }

    init{
        Log.i("RegisterViewModel", "GameViewModel created!")
    }
    override fun onCleared(){
        super.onCleared()
        Log.i("RegisterViewModel", "RegisterViewModel destroyed!")
    }
}