package com.example.andibagproject.feature.friend.load.model

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName

data class LoadMyProfileResponse(
    val nickname: String,
    val imageUrl: String,
    val phoneNumber: String
)