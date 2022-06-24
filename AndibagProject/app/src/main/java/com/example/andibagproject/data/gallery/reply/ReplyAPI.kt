package com.example.andibagproject.data.gallery.reply

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.*

interface ReplyAPI {
    @POST("reply/{id}")
    fun writeReply(
        @Header("Authorization") header: String,
        @Body content: String,
        @Path("id") id: Int
    ):Single<Response<Unit>>

    @DELETE("reply/{id}")
    fun deleteReply(
        @Header("Authorization") header: String,
        @Path("id") id: Int
    ):Single<Response<Unit>>

    @PUT("reply/{id}")
    fun patchReply(
        @Header("Authorization") header: String,
        @Body content: String,
        @Path("id") id: Int
    ):Single<Response<Unit>>
}