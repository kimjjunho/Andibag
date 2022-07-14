package com.example.andibagproject.feature.image

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.image.LoadImageAddressRepository
import okhttp3.MultipartBody

class LoadImageAddressViewModel(
    private val rp: LoadImageAddressRepository
): ViewModel() {

    val fileList = MutableLiveData<LoadImageAddressResponse>()
    val fail = MutableLiveData<Int>()

    fun loadImageAddress(list:MultipartBody.Part){
        rp.loadImageAddress(list)
            .subscribe { response ->
                if (response.isSuccessful) {
                    fileList.value = response.body()
                }else{
                    fail.value = response.code()
                }
            }
    }
}