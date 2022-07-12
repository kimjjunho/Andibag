package com.example.andibagproject.di.module

import com.example.andibagproject.data.myprofilefix.MyProfileFixRepository
import com.example.andibagproject.feature.myprofilefix.viewmodel.MyProfileFixViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myProfileFixModule = module {
    single { MyProfileFixRepository() }
    viewModel { MyProfileFixViewModel(get()) }
}