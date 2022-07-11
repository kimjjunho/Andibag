package com.example.andibagproject.feature.makeid.model

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody

data class MakeIdRequest(
    @SerializedName("nickname") val nickname : String,
    @SerializedName("accountId") val accountId : String,
    @SerializedName("password") val password : String,
    @SerializedName("phoneNumber") val phoneNumber : String,
    val imageUrl : String?
)
