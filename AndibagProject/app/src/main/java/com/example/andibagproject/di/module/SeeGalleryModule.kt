package com.example.andibagproject.di.module

import com.example.andibagproject.data.gallery.SeeGalleryRepository
import com.example.andibagproject.feature.gallery.main.viewmodel.SeeGalleryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val seeGalleryModule = module {
    single { SeeGalleryRepository() }
    viewModel { SeeGalleryViewModel(get()) }
}