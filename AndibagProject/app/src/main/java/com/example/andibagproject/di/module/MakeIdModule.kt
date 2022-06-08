package com.example.andibagproject.di.module

import com.example.andibagproject.data.login.LoginRepository
import com.example.andibagproject.data.makeid.MakeIdRepository
import com.example.andibagproject.feature.login.viewmodel.LoginViewModel
import com.example.andibagproject.feature.makeid.viewmodel.MakeIdViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val makeIdModule = module {
    single { MakeIdRepository() }
    viewModel { MakeIdViewModel(get()) }
}