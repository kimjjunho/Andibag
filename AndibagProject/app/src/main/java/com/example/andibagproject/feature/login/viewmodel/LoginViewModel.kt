package com.example.andibagproject.feature.login.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.Authority
import com.example.andibagproject.REFRESH_TOKEN
import com.example.andibagproject.data.login.LoginRepository
import com.example.andibagproject.feature.login.model.LoginRequest
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException
import java.lang.Exception
import java.net.ConnectException

class LoginViewModel(
    private val rp: LoginRepository
):ViewModel() {
    val success : MutableLiveData<Boolean> = MutableLiveData()
    val fail : MutableLiveData<Int> = MutableLiveData()

    fun login(loginRequest: LoginRequest) {
        rp.login(loginRequest)
            .subscribe( { response->
                Log.d(TAG, "login: try")
                if (response.isSuccessful) {
                    ACCESS_TOKEN = "Bearer " + response.body()?.accessToken.toString()
                    Log.d(TAG, "Bearer " + response.body()?.accessToken.toString())
                    REFRESH_TOKEN = response.body()?.refreshToken.toString()
                    Authority = response.body()?.Authority!!
                    success.value = true
                } else {
                    fail.value = response.code()
                }
            }, {
                when(it) {
                    is ConnectException -> fail.value = 500
                }
            })
    }
}