package com.example.andibagproject.model

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl("http://13.125.63.224:8080")
    addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    addConverterFactory(GsonConverterFactory.create())
}.build()

