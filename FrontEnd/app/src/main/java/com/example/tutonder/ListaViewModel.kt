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

class ListaViewModel : ViewModel() {
    private var responseReceived = MutableLiveData<List<User>>()
    val userResponse: LiveData<List<User>>
        get() = responseReceived

    init{
        Log.i("Request", "Tutors List")
    }

    fun getUser(id:String){
        TutoApi.retrofitService.getUsers().enqueue(object: Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if(response.isSuccessful){
                    //Guarda la lista de usuarios
                    responseReceived.value = response?.body()
                }else{
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                t?.printStackTrace()
            }
        })
    }
}