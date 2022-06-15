package com.example.andibagproject.feature.friend.add.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.addfriend.AddFriendRepository
import com.example.andibagproject.feature.friend.add.model.AddFriendRequest

class AddFriendViewModel(
    private val rp : AddFriendRepository
): ViewModel() {

    val success = MutableLiveData<Boolean>()
    val fail = MutableLiveData<Int>()

    fun addFriend(addFriendRequest: AddFriendRequest){
        rp.addFriend(addFriendRequest)
            .subscribe{ response ->
                if(response.isSuccessful){
                    success.value = true
                }else{
                    fail.value = response.code()
                }
            }
    }

}