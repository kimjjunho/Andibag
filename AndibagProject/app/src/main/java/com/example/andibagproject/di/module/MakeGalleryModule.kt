package com.example.andibagproject.di.module

import com.example.andibagproject.data.makegallery.MakeGalleryRepository
import com.example.andibagproject.feature.makegallery.viewmodel.MakeGalleryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val makeGalleryModule = module {
    single { MakeGalleryRepository() }
    viewModel { MakeGalleryViewModel(get()) }
}