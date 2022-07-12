package com.example.andibagproject.data.addfriend

import com.example.andibagproject.feature.friend.add.model.AddFriendRequest
import com.example.andibagproject.feature.friend.add.model.LoadToAddFriendResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AddFriendAPI {
    @POST("friend")
    fun addFriend(
        @Header("Authorization") header: String,
        @Body body: HashMap<String, String>
    ):Single<Response<Unit>>

    @POST("friend/find")
    fun loadFriend(
        @Header("Authorization") header: String,
        @Body addFriendRequest: AddFriendRequest
    ):Single<Response<LoadToAddFriendResponse>>

}