package com.example.andibagproject.data

import com.example.andibagproject.data.addfriend.AddFriendAPI
import com.example.andibagproject.data.gallery.main.GalleryAPI
import com.example.andibagproject.data.gallery.comment.CommentAPI
import com.example.andibagproject.data.gallery.reply.ReplyAPI
import com.example.andibagproject.data.image.LoadImageAddressAPI
import com.example.andibagproject.data.loadfriend.LoadFriendAPI
import com.example.andibagproject.data.login.LoginAPI
import com.example.andibagproject.data.makegallery.MakeGalleryAPI
import com.example.andibagproject.data.makeid.MakeIdAPI
import com.example.andibagproject.data.searchfriend.SearchFriendAPI
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl("http://3.39.194.47:8080/")
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

val galleryAPI : GalleryAPI by lazy {
    retrofit.create(GalleryAPI::class.java)
}

val addFriendAPI : AddFriendAPI by lazy {
    retrofit.create(AddFriendAPI::class.java)
}

val loadFriendAPI : LoadFriendAPI by lazy {
    retrofit.create(LoadFriendAPI::class.java)
}

val commentAPI : CommentAPI by lazy {
    retrofit.create(CommentAPI::class.java)
}

val replyAPI : ReplyAPI by lazy {
    retrofit.create(ReplyAPI::class.java)
}

val searchFriendAPI : SearchFriendAPI by lazy {
    retrofit.create(SearchFriendAPI::class.java)
}

val loadImageAddressAPI : LoadImageAddressAPI by lazy {
    retrofit.create(LoadImageAddressAPI::class.java)
}