package com.example.andibagproject.di.module

import com.example.andibagproject.data.gallery.main.GalleryRepository
import com.example.andibagproject.feature.gallery.main.viewmodel.GalleryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val galleryModule = module {
    single { GalleryRepository() }
    viewModel { GalleryViewModel(get()) }
}