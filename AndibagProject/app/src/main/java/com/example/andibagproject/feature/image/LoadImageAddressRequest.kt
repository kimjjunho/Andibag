package com.example.andibagproject.feature.image

import okhttp3.MultipartBody

data class LoadImageAddressRequest(
    val file : List<MultipartBody.Part?>
)
