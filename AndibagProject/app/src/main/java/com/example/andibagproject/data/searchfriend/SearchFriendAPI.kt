package com.example.andibagproject.data.searchfriend

import com.example.andibagproject.feature.friend.search.model.SearchFriendResponse
import com.example.andibagproject.feature.friend.search.model.SearchFriendResponseList
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header

interface SearchFriendAPI {
    @GET("search")
    fun searchFriend(
        @Header("Authorization") header: String,
        @Body nickname: String
    ):Single<Response<SearchFriendResponse>>

    @GET("memo")
    fun loadSearchFriendList(
        @Header("Authorization") header: String
    ):Single<Response<SearchFriendResponseList>>
}