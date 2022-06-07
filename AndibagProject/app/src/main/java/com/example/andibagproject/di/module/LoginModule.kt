package com.example.andibagproject.di.module

import com.example.andibagproject.data.login.LoginRepository
import com.example.andibagproject.feature.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    single { LoginRepository() }
    viewModel { LoginViewModel(get()) }
}