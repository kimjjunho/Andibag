package com.example.andibagproject.data.gallery

import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.data.seeGalleryAPI
import com.example.andibagproject.feature.gallery.model.SeeGalleryResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class SeeGalleryRepository {
    fun seeGallery() : @NonNull Single<Response<SeeGalleryResponse>> =
        seeGalleryAPI.see(ACCESS_TOKEN)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}