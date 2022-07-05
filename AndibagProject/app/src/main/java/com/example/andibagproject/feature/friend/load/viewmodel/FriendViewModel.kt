package com.example.andibagproject.feature.friend.load.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.loadfriend.LoadFriendRepository
import com.example.andibagproject.feature.friend.load.model.LoadFriendResponse
import com.example.andibagproject.feature.friend.load.model.LoadFriendResponseList
import retrofit2.Response

class FriendViewModel(
    private val rp : LoadFriendRepository
): ViewModel(){

    val success = MutableLiveData<Boolean>()
    val fail = MutableLiveData<Int>()

    val friendList = MutableLiveData<LoadFriendResponseList>()
    val list = listOf<Response<LoadFriendResponseList>>()


    fun loadFriend() {
        rp.loadFriend()
            .subscribe{ reaponse ->
                if(reaponse.isSuccessful){

                    success.value = true
                    friendList.value = reaponse.body()

                    Log.d(TAG, "loadFriend: ViewModelSuccessful")

                }else{
                    fail.value = reaponse.code()
                    Log.d(TAG, "loadFriend: ViewModelFail")

                }
            }
    }
}