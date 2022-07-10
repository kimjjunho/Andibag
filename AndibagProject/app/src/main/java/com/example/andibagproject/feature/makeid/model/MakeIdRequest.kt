package com.example.andibagproject.feature.makeid.model

import com.google.gson.annotations.SerializedName

data class MakeIdRequest(
    @SerializedName("nickname") val nickname : String,
    @SerializedName("accountId") val accountId : String,
    @SerializedName("password") val password : String,
    @SerializedName("phoneNumber") val phoneNumber : String,
    @SerializedName("imageUrl") val imageUrl: String?
)
