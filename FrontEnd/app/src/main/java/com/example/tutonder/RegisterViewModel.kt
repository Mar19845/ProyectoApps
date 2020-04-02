package com.example.tutonder

import android.util.Log
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {
    init{
        Log.i("RegisterViewModel", "GameViewModel created!")
    }
    override fun onCleared(){
        super.onCleared()
        Log.i("RegisterViewModel", "RegisterViewModel destroyed!")
    }
    private lateinit var viewModel:RegisterViewModel
}