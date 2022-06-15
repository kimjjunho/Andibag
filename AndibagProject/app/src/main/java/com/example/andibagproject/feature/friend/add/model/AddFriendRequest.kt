package com.example.andibagproject.feature.friend.add.model

import com.google.gson.annotations.SerializedName

data class AddFriendRequest(
    @SerializedName("phoneNumber") val phoneNumber: String
)