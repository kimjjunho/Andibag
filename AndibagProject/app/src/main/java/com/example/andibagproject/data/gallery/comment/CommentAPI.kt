package com.example.andibagproject.data.gallery.comment

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.*

interface CommentAPI {
    @POST("comment/{id}")
    fun writeComment(
        @Header("Authorization") header: String,
        @Body content: String,
        @Path("id") id: Long
    ):Single<Response<Unit>>

    @DELETE("comment/{id}")
    fun deleteComment(
        @Header("Authorization") header: String,
        @Path("id") id: Long
    ):Single<Response<Unit>>

    @PUT("comment/{id}")
    fun patchComment(
        @Header("Authorization") header: String,
        @Body content: String,
        @Path("id") id: Long
    ):Single<Response<Unit>>
}