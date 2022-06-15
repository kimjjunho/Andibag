package com.example.andibagproject.data.loadfriend

import com.example.andibagproject.feature.friend.load.model.LoadFriendResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface LoadFriendAPI {
    @GET
    fun loadFriend(
        @Header("Authorization") header: String
    ): Single<Response<LoadFriendResponse>>
}