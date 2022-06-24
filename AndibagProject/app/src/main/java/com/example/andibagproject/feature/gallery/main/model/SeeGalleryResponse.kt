package com.example.andibagproject.feature.gallery.main.model

import com.google.gson.annotations.SerializedName

data class SeeGalleryResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String,
    @SerializedName("createAt") val createAt: String,
    @SerializedName("modifyAt") val modifyAt: String
)
