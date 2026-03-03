package com.example.retrofit

import retrofit2.Retrofit
import kotlin.getValue
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://meme-api.com/").addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiInterface by lazy{
        retrofit.create(ApiInterface::class.java)


    }
}