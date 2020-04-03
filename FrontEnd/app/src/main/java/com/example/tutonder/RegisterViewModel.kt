package com.example.tutonder

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tutonder.network.TutoApi
import com.example.tutonder.network.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel: ViewModel() {
    private var responseReceived = MutableLiveData<User>()
    val userResponse: LiveData<User>
        get() = responseReceived

    init{
        Log.i("Request", "Login User")
    }

    fun getUser(id:String){
        TutoApi.retrofitService.getUser(id).enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    //Guardar body de la respuesta en el mutable live data
                    responseReceived.value = response?.body()
                }else{
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                t?.printStackTrace()
            }
        })
    }
}