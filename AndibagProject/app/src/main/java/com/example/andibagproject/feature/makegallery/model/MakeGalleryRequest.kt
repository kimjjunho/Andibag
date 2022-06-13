package com.example.andibagproject.feature.makegallery.model

import com.google.gson.annotations.SerializedName

data class MakeGalleryRequest(
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String
    )
