package com.example.andibagproject.feature.makeid.model

import com.google.gson.annotations.SerializedName

data class MakeIdRequest(
    @SerializedName("accountId") val accountId : String,
    @SerializedName("password") val password : String,
    @SerializedName("nickname") val nickname : String,
    @SerializedName("phoneNumber") val phoneNumber : String,
)