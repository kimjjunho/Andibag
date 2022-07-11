package com.example.andibagproject.data.image

import com.example.andibagproject.feature.image.LoadImageAddressRequest
import com.example.andibagproject.feature.image.LoadImageAddressResponse
import io.reactivex.rxjava3.core.Single
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface LoadImageAddressAPI {

    @Multipart
    @POST("image")
    fun loadImageAddress(
        @Part loadImageAddressRequest: LoadImageAddressRequest
    ):Single<Response<LoadImageAddressResponse>>

}