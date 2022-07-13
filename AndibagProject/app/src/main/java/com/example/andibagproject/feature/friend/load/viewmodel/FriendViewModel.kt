package com.example.andibagproject.feature.friend.load.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.loadfriend.LoadFriendRepository
import com.example.andibagproject.feature.friend.load.model.LoadFriendResponseList
import retrofit2.Response

class FriendViewModel(
    private val rp : LoadFriendRepository
): ViewModel(){

    val success = MutableLiveData<Boolean>()
    val fail = MutableLiveData<Int>()

    val friendList = MutableLiveData<LoadFriendResponseList>()
    val list = listOf<Response<LoadFriendResponseList>>()

    val myNickname = MutableLiveData<String>()
    val myImageUrl = MutableLiveData<String>()
    val myPhoneNumber = MutableLiveData<String>()
    val myProfileFail = MutableLiveData<Int>()

    val delete = MutableLiveData<String>()


    fun loadFriend() {
        rp.loadFriend()
            .subscribe{ reaponse ->
                if(reaponse.isSuccessful){

                    success.value = true
                    friendList.value = reaponse.body()
                    
                }else{
                    fail.value = reaponse.code()

                }
            }
    }

    fun loadMyProfile() {
        rp.loadMyProfile()
            .subscribe{ respone->
                if(respone.isSuccessful){
                    Log.d(TAG, "loadMyProfile: success")
                    myNickname.value = respone.body()!!.nickname
                    myImageUrl.value = respone.body()!!.imageUrl
                    myPhoneNumber.value = respone.body()!!.phoneNumber

                }else{
                    Log.d(TAG, "loadMyProfile: "+respone.code())
                    myProfileFail.value = respone.code()
                }
            }
    }

    fun deleteFriend(id: Long) {
        rp.deleteFriend(id)
            .subscribe{ response->
                Log.d(TAG, "deleteFriend: "+response.code())
                if(response.isSuccessful){
                    delete.value = "친구 삭제를 성공했습니다"
                }else{
                    delete.value = "친구 삭제를 실패했습니다"
                }
            }
    }
}