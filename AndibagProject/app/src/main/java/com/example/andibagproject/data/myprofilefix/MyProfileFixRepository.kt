package com.example.andibagproject.data.myprofilefix

import com.example.andibagproject.data.myProfileFixAPI
import com.example.andibagproject.feature.myprofilefix.model.MyProfileFixRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MyProfileFixRepository {
    fun fixProfile(myProfileFixRequest: MyProfileFixRequest) : @NonNull Single<Response<Unit>> =
        myProfileFixAPI.myProfileFix(myProfileFixRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}