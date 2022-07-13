package com.example.andibagproject.data.loadfriend

import com.example.andibagproject.feature.friend.load.model.LoadFriendResponseList
import com.example.andibagproject.feature.friend.load.model.LoadMyProfileResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface LoadFriendAPI {
    @GET("friend")
    fun loadFriend(
        @Header("Authorization") header: String
    ): Single<Response<LoadFriendResponseList>>

    @GET("user/my")
    fun loadMyProfile(
        @Header("Authorization") header: String
    ): Single<Response<LoadMyProfileResponse>>

    @DELETE("friend/{id}")
    fun deleteFriend(
        @Header("Authorization") header: String,
        @Path("id") id: Long
    ): Single<Response<Unit>>
}