package com.example.andibagproject.data.gallery.comment.write

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface WriteCommentAPI {
    @POST("comment/{id}")
    fun writeComment(
        @Header("Authorization") header: String,
        @Body content: String,
        @Path("id") id: Int
    ):Single<Response<Unit>>
}