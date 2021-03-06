package com.example.andibagproject.data.searchfriend

import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.data.searchFriendAPI
import com.example.andibagproject.feature.friend.search.model.SearchFriendRequest
import com.example.andibagproject.feature.friend.search.model.SearchFriendResponse
import com.example.andibagproject.feature.friend.search.model.SearchFriendResponseList
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class SearchFriendRepository {
    fun searchFriend(searchFriendRequest: SearchFriendRequest) : @NonNull Single<Response<SearchFriendResponse>> =
        searchFriendAPI.searchFriend(ACCESS_TOKEN,searchFriendRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun loadSearchFriendList() : @NonNull Single<Response<SearchFriendResponseList>> =
        searchFriendAPI.loadSearchFriendList(ACCESS_TOKEN)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun deleteFriendList(id: Long) : @NonNull Single<Response<Unit>> =
        searchFriendAPI.deleteSearchFriendList(ACCESS_TOKEN,id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun deleteAllFriendList() : @NonNull Single<Response<Unit>> =
        searchFriendAPI.deleteAllSearchFriendList(ACCESS_TOKEN)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}