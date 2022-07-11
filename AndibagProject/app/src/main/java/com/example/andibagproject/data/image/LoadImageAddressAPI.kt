package com.example.andibagproject.data.image

import com.example.andibagproject.feature.image.LoadImageAddressResponse
import io.reactivex.rxjava3.core.Single
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*


interface LoadImageAddressAPI {

    @Multipart
    @POST("image")
    fun loadImageAddress(
        @Part file:MultipartBody.Part
    ):Single<Response<LoadImageAddressResponse>>

}