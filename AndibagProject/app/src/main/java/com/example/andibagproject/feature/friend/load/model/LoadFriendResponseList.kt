package com.example.andibagproject.feature.friend.load.model

data class LoadFriendResponseList(
    val friendList: List<LoadFriendResponse>
)

data class LoadFriendResponse(
    val id: Long,
    val nickname: String,
    val imageUrl: String?, //서버에서 imageURL이 null로 올 경우 string이 non-nullable 할 시 앱이 터진다
    val phoneNumber: String
)

