package com.example.andibagproject.data.login

import com.example.andibagproject.feature.login.model.LoginRequest
import com.example.andibagproject.feature.login.model.LoginResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {
    @POST("user/login")
    fun login(
        @Body loginRequest: LoginRequest
    ):Single<Response<LoginResponse>>
}