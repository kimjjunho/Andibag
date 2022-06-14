package com.example.andibagproject.data.login

import android.content.ContentValues
import android.util.Log
import com.example.andibagproject.data.loginAPI
import com.example.andibagproject.feature.login.model.LoginRequest
import com.example.andibagproject.feature.login.model.LoginResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class LoginRepository {
    fun login(loginRequest: LoginRequest) : @NonNull Single<Response<LoginResponse>> =
        loginAPI.login(loginRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError { throwable ->
                Log.d(ContentValues.TAG, "Error: $throwable")
            }
}