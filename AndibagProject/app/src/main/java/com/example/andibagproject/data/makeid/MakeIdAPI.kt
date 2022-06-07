package com.example.andibagproject.data.makeid

import com.example.andibagproject.feature.makeid.model.MakeIdRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface MakeIdAPI {
    @POST("signup")
    fun signup(
        @Body makeIdRequest : MakeIdRequest
    ) : Single<Void>
}