package com.example.andibagproject.data.loadfriend

import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.data.loadFriendAPI
import com.example.andibagproject.feature.friend.load.model.LoadFriendResponse
import io.reactivex.Single
import retrofit2.Response

class LoadFriendRepository {
    fun loadFriend() : Single<Response<LoadFriendResponse>> =
        loadFriendAPI.loadFriend(ACCESS_TOKEN)
}
