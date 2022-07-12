package com.example.andibagproject.feature.friend.search.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.searchfriend.SearchFriendRepository
import com.example.andibagproject.feature.friend.search.model.SearchFriendRequest
import com.example.andibagproject.feature.friend.search.model.SearchFriendResponseList

class SearchFriendViewModel(
    private val rp: SearchFriendRepository
): ViewModel() {

    val searchSuccess = MutableLiveData<Boolean>()
    val searchFail = MutableLiveData<Int>()
    val searchId = MutableLiveData<Long>()
    val searchNickname = MutableLiveData<String>()
    val searchPhoneNumber = MutableLiveData<String>()

    val loadFail = MutableLiveData<Int>()
    val loadList = MutableLiveData<SearchFriendResponseList>()

    val deleteSuccess = MutableLiveData<Int>()
    val deleteFail = MutableLiveData<Int>()

    val deleteAllSuccess = MutableLiveData<Int>()
    val deleteAllFail = MutableLiveData<Int>()

    fun searchFriend(searchFriendRequest: SearchFriendRequest) {
        rp.searchFriend(searchFriendRequest)
            .subscribe { response ->
                if (response.isSuccessful) {
                    searchSuccess.value = true
                    searchId.value = response.body()!!.id
                    searchNickname.value = response.body()!!.nickname
                    searchPhoneNumber.value = response.body()!!.phoneNumber
                } else {
                    searchFail.value = response.code()
                }

            }
    }

    fun loadSearchFriendList(){
        rp.loadSearchFriendList()
            .subscribe{ response ->
                Log.d(TAG, "loadSearchFriendList: "+response.code())
                if(response.isSuccessful){
                    loadList.value = response.body()
                }else{
                    loadFail.value = response.code()
                }

            }
    }

    fun deleteFriendList(id:Long){
        rp.deleteFriendList(id)
            .subscribe{ response ->
                if(response.isSuccessful){
                    deleteSuccess.value = response.code()
                }else{
                    deleteFail.value = response.code()
                }
            }
    }

    fun deleteAllFriendList() {
        rp.deleteAllFriendList()
            .subscribe{ response->
                if(response.isSuccessful){
                    deleteAllSuccess.value = response.code()
                }else{
                    deleteAllFail.value = response.code()
                }
            }
    }
}
