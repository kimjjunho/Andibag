package com.example.andibagproject.data.loadfriend

import com.example.andibagproject.feature.friend.load.model.LoadFriendResponseList
import com.example.andibagproject.feature.friend.load.model.LoadMyProfileResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface LoadFriendAPI {
    @GET("friend")
    fun loadFriend(
        @Header("Authorization") header: String
    ): Single<Response<LoadFriendResponseList>>

    @GET("user/my")
    fun loadMyProfile(
        @Header("Authorization") header: String
    ): Single<Response<LoadMyProfileResponse>>
}