package com.example.andibagproject.data.searchfriend

import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.data.searchFriendAPI
import com.example.andibagproject.feature.friend.search.model.SearchFriendResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class SearchFriendRepository {
    fun searchFriend(nickname: String) : @NonNull Single<Response<SearchFriendResponse>> =
        searchFriendAPI.searchFriend(ACCESS_TOKEN,nickname)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}