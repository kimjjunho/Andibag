package com.example.andibagproject.feature.friend.load.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.loadfriend.LoadFriendRepository

class FriendViewModel(
    private val rp : LoadFriendRepository
): ViewModel(){

    val success = MutableLiveData<Boolean>()
    val fail = MutableLiveData<Int>()

    fun loadFriend() {
        rp.loadFriend()
            .subscribe{ reaponse ->
                if(reaponse.isSuccessful){
                    success.value = true
                }else{
                    fail.value = reaponse.code()
                }
            }
    }
}