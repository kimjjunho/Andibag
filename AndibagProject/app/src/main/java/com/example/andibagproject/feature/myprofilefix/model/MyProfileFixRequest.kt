package com.example.andibagproject.feature.myprofilefix.model

import com.google.gson.annotations.SerializedName

data class MyProfileFixRequest(
    @SerializedName("nickname") val nickname: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("phoneNumber") val phoneNumber: String
)
