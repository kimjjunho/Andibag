package com.example.andibagproject.data.myprofilefix

import com.example.andibagproject.feature.myprofilefix.model.MyProfileFixRequest
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.Header
import retrofit2.http.PATCH
import java.util.*
import kotlin.collections.HashMap

interface MyProfileFixAPI {
    @PATCH("user/my")
    fun myProfileFix(
        @Header("Authorization") header: String,
        @Body myProfileFixRequest: MyProfileFixRequest
    ):Single<Response<Unit>>

}