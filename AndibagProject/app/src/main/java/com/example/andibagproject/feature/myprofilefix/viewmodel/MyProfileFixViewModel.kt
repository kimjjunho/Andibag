package com.example.andibagproject.feature.myprofilefix.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.myprofilefix.MyProfileFixRepository
import com.example.andibagproject.feature.myprofilefix.model.MyProfileFixRequest

class MyProfileFixViewModel(
    private val rp: MyProfileFixRepository
): ViewModel() {

    val success = MutableLiveData<Boolean>()
    val fail = MutableLiveData<Int>()

    fun myProfileFix(myProfileFixRequest: MyProfileFixRequest){
        rp.myProfileFix(myProfileFixRequest)
            .subscribe{ response->
                Log.d(TAG, "myProfileFix: "+response.code())
                if(response.isSuccessful){
                    success.value = true
                }else{
                    fail.value = response.code()
                }
            }
    }
}