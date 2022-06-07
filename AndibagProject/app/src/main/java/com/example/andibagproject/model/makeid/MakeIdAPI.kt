package com.example.andibagproject.model.makeid

import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface MakeIdAPI {
    @POST("signup")
    fun signup(
        @Body makeIdRequest : MakeIdRequest
    ) : Single<Void>
}