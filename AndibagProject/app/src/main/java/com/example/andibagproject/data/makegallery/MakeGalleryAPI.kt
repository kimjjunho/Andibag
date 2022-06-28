package com.example.andibagproject.data.makegallery

import com.example.andibagproject.feature.makegallery.model.MakeGalleryRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.*

interface MakeGalleryAPI {
    @POST("notice")
    fun makeGallery(
        @Header("Authorization") Authorization: String,
        @Body makeGalleryRequest: MakeGalleryRequest
    ): Single<Response<Unit>>

    @PUT("notice/{id}")
    fun fixGallery(
        @Header("Authorization") Authorization: String,
        @Body makeGalleryRequest: MakeGalleryRequest,
        @Path("id") id: Long
    ): Single<Response<Unit>>
}