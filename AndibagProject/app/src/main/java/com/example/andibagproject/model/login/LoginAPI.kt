package com.example.andibagproject.model.login

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {
    @POST("login")
    fun login(
        @Body loginRequest: LoginRequest
    ):Single<Response<Void>>
}