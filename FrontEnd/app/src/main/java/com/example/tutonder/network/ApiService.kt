package com.example.tutonder.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Path

private const val BASE_URL = "https://1317841e.ngrok.io/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface GitApiService {

    @GET("tutores")
    fun getTutores(): Call<List<User>>

    @GET("usuarios")
    fun getUsers(): Call<List<User>>

    @GET("usuarios/{id}")
    fun getUser(@Path("id") id: String): Call<User>

    @POST("usuarios/{id}")
    fun postUser(@Path("id") id: String): Call<User>

}

object TutoApi {
    val retrofitService : GitApiService by lazy { retrofit.create(GitApiService::class.java) }
}