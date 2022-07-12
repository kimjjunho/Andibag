package com.example.andibagproject.feature.friend.add.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.addfriend.AddFriendRepository
import com.example.andibagproject.feature.friend.add.model.AddFriendRequest
import com.example.andibagproject.util.loadImage

class AddFriendViewModel(
    private val rp : AddFriendRepository
): ViewModel() {

    private val _addSuccess = MutableLiveData<Boolean>()
    val addSuccess: LiveData<Boolean> = _addSuccess
    val addFail = MutableLiveData<Int>()

    //val loadSuccess = MutableLiveData<Boolean>()
    //val loadFail = MutableLiveData<Int>()
    val loadId = MutableLiveData<Long>()
    val loadNickname = MutableLiveData<String>()
    val loadPhoneNumber = MutableLiveData<String>()
    val loadImageUrl = MutableLiveData<String>()

    fun addFriend(addFriendRequest: String){
        Log.d(TAG, "addFriend: ")
        val body = HashMap<String, String>()
        body["nickname"] = addFriendRequest
        rp.addFriend(body)
            .doOnError {
                Log.d(TAG, "Error: $it")
            }
            .subscribe{ response ->

                if(response.isSuccessful){
                    _addSuccess.value = true
                }else{
                    Log.d(TAG, "addFriend: ${response.code()}")
                    addFail.value = response.code()
                }
            }
    }

    fun loadFriend(phoneNumber: AddFriendRequest){
        rp.loadFriend(phoneNumber)
            .doOnError {
                Log.d(TAG, "Error: $it")
            }
            .subscribe{ response ->
                Log.d(TAG, "loadFriend: $phoneNumber")
                if(response.isSuccessful){
                    loadId.value = response.body()!!.id
                    loadNickname.value = response.body()!!.nickname
                    loadPhoneNumber.value = response.body()!!.phoneNumber
                    loadImageUrl.value = response.body()!!.imageUrl
                }else{
                    Log.d(TAG, "loadFriend: "+response.code())
                    addFail.value = response.code()
                }
            }
    }

}