package com.example.andibagproject.data.loadfriend

import com.example.andibagproject.feature.friend.load.model.LoadFriendResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.POST

interface LoadFriendAPI {
    @POST("friend")
    fun loadFriend(
        @Header("Authorization") header: String
    ): Single<Response<LoadFriendResponse>>
}