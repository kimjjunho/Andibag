package com.example.andibagproject.feature.friend.add.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
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
        Log.d(TAG, "addFriend: ")
        rp.addFriend(addFriendRequest)
            .doOnError {
                Log.d(TAG, "Error: $it")
            }
            .subscribe{ response ->
                if(response.isSuccessful){
                    success.value = true
                }else{
                    Log.d(TAG, "addFriend: ${response.code()}")
                    fail.value = response.code()
                }
            }
    }

}