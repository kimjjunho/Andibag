package com.example.andibagproject.feature.login.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.Authority
import com.example.andibagproject.REFRESH_TOKEN
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
    val success : MutableLiveData<Boolean> = MutableLiveData()
    val fail : MutableLiveData<Boolean> = MutableLiveData()

    fun login(loginRequest: LoginRequest){
        rp.login(loginRequest)
            .doOnError { throwable ->
                Log.d(TAG, "Error: $throwable")
            }
            .subscribe{ response->
                if(response.isSuccessful){
                    ACCESS_TOKEN = "Bearer " + response.body()?.accessToken.toString()
                    REFRESH_TOKEN = response.body()?.refreshToken.toString()
                    Authority = response.body()?.Authority!!
                    success.value = true
                }else{
                    fail.value = true
                }
            }
    }
}