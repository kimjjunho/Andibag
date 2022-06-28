package com.example.andibagproject.feature.gallery.comment.data

import com.google.gson.annotations.SerializedName

data class LoadCommentResponse(
    @SerializedName("list") val list: String
)