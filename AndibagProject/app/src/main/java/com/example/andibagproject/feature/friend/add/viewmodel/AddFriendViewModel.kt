package com.example.andibagproject.feature.friend.add.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.addfriend.AddFriendRepository

class AddFriendViewModel(
    val rp : AddFriendRepository
): ViewModel() {

    val success = MutableLiveData<Boolean>()
    val fail = MutableLiveData<Int>()


}