package com.example.andibagproject.data.makegallery

import com.example.andibagproject.feature.makegallery.model.MakeGalleryRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface MakeGalleryAPI {
    @POST("notice")
    fun makeGallery(
        @Header("Authorization") header: String,
        @Body makeGalleryRequest: MakeGalleryRequest
    ): Single<Response<Unit>>
}