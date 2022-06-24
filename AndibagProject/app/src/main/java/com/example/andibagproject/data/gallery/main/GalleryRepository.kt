package com.example.andibagproject.data.gallery.main

import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.data.galleryAPI
import com.example.andibagproject.feature.gallery.main.model.SeeGalleryResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class GalleryRepository {
    fun seeGallery() : @NonNull Single<Response<SeeGalleryResponse>> =
        galleryAPI.seeGallery(ACCESS_TOKEN)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}