package com.example.andibagproject.data.makegallery


import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.data.makeGalleryAPI
import com.example.andibagproject.feature.makegallery.model.MakeGalleryRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MakeGalleryRepository {
    fun makeGallery(makeGalleryRequest: MakeGalleryRequest) : @NonNull Single<Response<Unit>> =
        makeGalleryAPI.makeGallery(ACCESS_TOKEN,makeGalleryRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun fixGallery(makeGalleryRequest: MakeGalleryRequest, id: Long) : @NonNull Single<Response<Unit>> =
        makeGalleryAPI.fixGallery(ACCESS_TOKEN,makeGalleryRequest,id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}