package com.example.andibagproject.data.makeid

import android.accounts.Account
import com.example.andibagproject.data.makeIdAPI
import com.example.andibagproject.feature.login.model.LoginRequest
import com.example.andibagproject.feature.makeid.model.MakeIdRequest
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class MakeIdRepository {
    fun makeId(makeIdRequest: MakeIdRequest) : @NonNull Single<Response<Unit>> =
        makeIdAPI.signup(makeIdRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun checkId(accountId: String): @NonNull Single<Response<Unit>> =
        makeIdAPI.checkId(accountId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}