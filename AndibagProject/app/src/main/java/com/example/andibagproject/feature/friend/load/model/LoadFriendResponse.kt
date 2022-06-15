package com.example.andibagproject.feature.friend.load.model

import com.google.gson.annotations.SerializedName

data class LoadFriendResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("phoneNumber") val phoneNumber: String
)