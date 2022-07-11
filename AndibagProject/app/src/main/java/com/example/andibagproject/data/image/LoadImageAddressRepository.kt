package com.example.andibagproject.data.image

import com.example.andibagproject.data.loadImageAddressAPI
import com.example.andibagproject.feature.image.LoadImageAddressResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.MultipartBody
import retrofit2.Response

class LoadImageAddressRepository {
    fun loadImageAddress(file: MultipartBody.Part) : @NonNull Single<Response<LoadImageAddressResponse>> =
        loadImageAddressAPI.loadImageAddress(file)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}