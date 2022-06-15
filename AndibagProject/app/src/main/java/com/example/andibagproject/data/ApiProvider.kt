package com.example.andibagproject.data

import com.example.andibagproject.data.addfriend.AddFriendAPI
import com.example.andibagproject.data.gallery.SeeGalleryAPI
import com.example.andibagproject.data.loadfriend.LoadFriendAPI
import com.example.andibagproject.data.login.LoginAPI
import com.example.andibagproject.data.makegallery.MakeGalleryAPI
import com.example.andibagproject.data.makeid.MakeIdAPI
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl("http://15.164.67.132:8080")
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

val addFriendAPI : AddFriendAPI by lazy {
    retrofit.create(AddFriendAPI::class.java)
}

val loadFriendAPI : LoadFriendAPI by lazy {
    retrofit.create(LoadFriendAPI::class.java)
}