package com.example.andibagproject.feature.makeid.viewmodel

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.Authority
import com.example.andibagproject.REFRESH_TOKEN
import com.example.andibagproject.data.makeid.MakeIdRepository
import com.example.andibagproject.feature.makeid.model.MakeIdRequest

class MakeIdViewModel(
    private val rp: MakeIdRepository
) : ViewModel() {

    val success : MutableLiveData<Boolean> = MutableLiveData()
    val fail : MutableLiveData<Int> = MutableLiveData()

    fun makeId(makeIdRequest: MakeIdRequest){
        rp.makeId(makeIdRequest)
            .doOnError { throwable ->
                Log.d(TAG, "Error: $throwable")
            }
            .subscribe{ response->
                if(response.isSuccessful){
                    success.value = true
                }else{
                    fail.value = response.code()
                }
            }
    }

}