package com.example.andibagproject.feature.friend.load.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.loadfriend.LoadFriendRepository

class FriendViewModel(
    private val rp : LoadFriendRepository
): ViewModel(){

    val success = MutableLiveData<Boolean>()
    val fail = MutableLiveData<Int>()
    val id = MutableLiveData<Long>()
    val password = MutableLiveData<String>()
    val phonenumber = MutableLiveData<String>()


    fun loadFriend() {
        rp.loadFriend()
            .subscribe{ reaponse ->
                if(reaponse.isSuccessful){
                    success.value = true
                    id.value = reaponse.body()?.id
                    password.value = reaponse.body()?.nickname
                    phonenumber.value = reaponse.body()?.phoneNumber

                }else{
                    fail.value = reaponse.code()
                }
            }
    }
}