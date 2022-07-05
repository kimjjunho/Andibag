package com.example.andibagproject.feature.friend.load.model

data class LoadFriendResponseList(
    val friendList: List<LoadFriendResponse>
)

data class LoadFriendResponse(
    val id: Long,
    val nickname: String,
    val phoneNumber: String
)

