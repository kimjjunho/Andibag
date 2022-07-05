package com.example.andibagproject.feature.friend.search.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.searchfriend.SearchFriendRepository

class SearchFriendViewModel(
    private val rp: SearchFriendRepository
): ViewModel() {

    val searchSuccess = MutableLiveData<Boolean>()
    val searchFail = MutableLiveData<Int>()
    val searchId = MutableLiveData<Long>()
    val searchNickname = MutableLiveData<String>()
    val searchPhoneNumber = MutableLiveData<String>()

    fun searchFriend(nickname: String){
        rp.searchFriend(nickname)
            .subscribe{ response ->
                if(response.isSuccessful){
                    searchId.value = response.body()!!.id
                    searchNickname.value = response.body()!!.nickname
                    searchPhoneNumber.value = response.body()!!.phoneNumber
                    searchSuccess.value = true
                }else{
                    searchFail.value = response.code()
                }

            }
    }
}