package com.example.andibagproject.feature.login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.andibagproject.data.login.LoginRepository
import com.example.andibagproject.data.loginAPI
import com.example.andibagproject.feature.login.model.LoginRequest
import com.example.andibagproject.feature.login.model.LoginResponse
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class LoginViewModel(
    private val rp: LoginRepository
):ViewModel() {

}