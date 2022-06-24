package com.example.andibagproject.data.gallery

import com.example.andibagproject.feature.gallery.main.model.SeeGalleryResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface SeeGalleryAPI {
    @GET("notice")
    fun see(
        @Header("Authorization") header: String
    ):Single<Response<SeeGalleryResponse>>
}