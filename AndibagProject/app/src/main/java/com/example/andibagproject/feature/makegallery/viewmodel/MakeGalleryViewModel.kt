package com.example.andibagproject.feature.makegallery.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.makegallery.MakeGalleryRepository
import com.example.andibagproject.feature.makegallery.model.MakeGalleryRequest

class MakeGalleryViewModel(
    private val rp: MakeGalleryRepository
):ViewModel() {

    val success : MutableLiveData<Boolean> = MutableLiveData()
    val fail : MutableLiveData<Int> = MutableLiveData()

    fun makeGallery(makeGalleryRequest: MakeGalleryRequest){
        rp.makeGallery(makeGalleryRequest)
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