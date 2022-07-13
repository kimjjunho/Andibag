package com.example.andibagproject.data.loadfriend

import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.data.loadFriendAPI
import com.example.andibagproject.feature.friend.load.model.LoadFriendResponseList
import com.example.andibagproject.feature.friend.load.model.LoadMyProfileResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response
import io.reactivex.rxjava3.core.Single

class LoadFriendRepository {
    fun loadFriend() : @NonNull Single<Response<LoadFriendResponseList>> =
        loadFriendAPI.loadFriend(ACCESS_TOKEN)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun loadMyProfile() : @NonNull Single<Response<LoadMyProfileResponse>> =
        loadFriendAPI.loadMyProfile(ACCESS_TOKEN)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun deleteFriend(id: Long): @NonNull Single<Response<Unit>> =
        loadFriendAPI.deleteFriend(ACCESS_TOKEN,id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}
