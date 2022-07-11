package com.example.andibagproject.di.module

import com.example.andibagproject.data.image.LoadImageAddressRepository
import com.example.andibagproject.feature.image.LoadImageAddressViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loadImageAddressModule = module {
    single { LoadImageAddressRepository() }
    viewModel { LoadImageAddressViewModel(get()) }
}