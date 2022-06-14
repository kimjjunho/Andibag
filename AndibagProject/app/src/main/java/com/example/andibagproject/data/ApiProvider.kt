package com.example.andibagproject.data

import com.example.andibagproject.data.gallery.SeeGalleryAPI
import com.example.andibagproject.data.login.LoginAPI
import com.example.andibagproject.data.makegallery.MakeGalleryAPI
import com.example.andibagproject.data.makeid.MakeIdAPI
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl("http://52.79.243.184:8080")
    addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    addConverterFactory(GsonConverterFactory.create())
}.build()

val makeIdAPI : MakeIdAPI by lazy {
    retrofit.create(MakeIdAPI::class.java)
}

val loginAPI : LoginAPI by lazy {
    retrofit.create(LoginAPI::class.java)
}

val makeGalleryAPI : MakeGalleryAPI by lazy {
    retrofit.create(MakeGalleryAPI::class.java)
}

val seeGalleryAPI : SeeGalleryAPI by lazy {
    retrofit.create(SeeGalleryAPI::class.java)
}