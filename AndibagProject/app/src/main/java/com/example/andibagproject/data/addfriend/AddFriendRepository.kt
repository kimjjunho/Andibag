package com.example.andibagproject.data.addfriend

import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.data.addFriendAPI
import com.example.andibagproject.feature.friend.add.model.AddFriendRequest
import com.example.andibagproject.feature.friend.add.model.LoadToAddFriendResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class AddFriendRepository {
    fun addFriend(addFriendRequest: AddFriendRequest) : @NonNull Single<Response<Unit>> =
        addFriendAPI.addFriend(ACCESS_TOKEN, addFriendRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun loadFriend(addFriendRequest: AddFriendRequest) : @NonNull Single<Response<LoadToAddFriendResponse>> =
        addFriendAPI.loadFriend(ACCESS_TOKEN,addFriendRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())



}