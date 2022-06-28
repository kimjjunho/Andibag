package com.example.andibagproject.data.gallery.main

import com.example.andibagproject.feature.gallery.main.model.SeeGalleryCategory
import com.example.andibagproject.feature.gallery.main.model.SeeGalleryResponse
import com.example.andibagproject.feature.gallery.main.model.WriteGalleryRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.*

interface GalleryAPI {
    @GET("notice/{category}")
    fun seeGallery(
        @Header("Authorization") header: String,
        @Path("category") category: SeeGalleryCategory
    ):Single<Response<SeeGalleryResponse>>

    @POST("notice")
    fun writeGallery(
        @Header("Authorization") header: String,
        @Body writeGalleryRequest: WriteGalleryRequest
    ):Single<Response<Unit>>

    @PUT("notice/{id}")
    fun patchGallery(
        @Header("Authorization") header: String,
        @Body writeGalleryRequest: WriteGalleryRequest,
        @Path("id") id: Long
    ):Single<Response<Unit>>
}