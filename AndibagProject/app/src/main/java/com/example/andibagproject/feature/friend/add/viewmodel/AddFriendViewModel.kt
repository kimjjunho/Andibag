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

    val addSuccess = MutableLiveData<Boolean>()
    val addFail = MutableLiveData<Int>()

    //val loadSuccess = MutableLiveData<Boolean>()
    //val loadFail = MutableLiveData<Int>()
    val loadId = MutableLiveData<Long>()
    val loadNickname = MutableLiveData<String>()
    val loadPhoneNumber = MutableLiveData<String>()

    fun addFriend(addFriendRequest: AddFriendRequest){
        Log.d(TAG, "addFriend: ")
        rp.addFriend(addFriendRequest)
            .doOnError {
                Log.d(TAG, "Error: $it")
            }
            .subscribe{ response ->
                if(response.isSuccessful){
                    addSuccess.value = true
                }else{
                    Log.d(TAG, "addFriend: ${response.code()}")
                    addFail.value = response.code()
                }
            }
    }

    fun loadFriend(addFriendRequest: AddFriendRequest){
        rp.loadFriend(addFriendRequest)
            .doOnError {
                Log.d(TAG, "Error: $it")
            }
            .subscribe{ response ->
                if(response.isSuccessful){
                    loadId.value = response.body()!!.id
                    loadNickname.value = response.body()!!.nickname
                    loadPhoneNumber.value = response.body()!!.phoneNumber
                }else{
                    Log.d(TAG, "loadFriend: "+response.code())
                    addFail.value = response.code()
                }
            }
    }

}