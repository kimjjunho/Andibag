package com.example.andibagproject.feature.gallery.main.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.gallery.main.GalleryRepository

class GalleryViewModel(
    private val rp : GalleryRepository
):ViewModel() {

    val success: MutableLiveData<Boolean> = MutableLiveData()
    val fail: MutableLiveData<Int> = MutableLiveData()

    fun seeGallery(){
        rp.seeGallery()
            .doOnError { throwable->
                Log.d(TAG, "Error: $throwable")
            }
            .subscribe { response->
                if(response.isSuccessful){
                    success.value = true
                }else{
                    fail.value = response.code()
                }
            }
    }
}