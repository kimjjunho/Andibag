package com.example.andibagproject.di.module

import com.example.andibagproject.data.gallery.SeeGalleryRepository
import com.example.andibagproject.data.gallery.comment.write.WriteCommentRepository
import com.example.andibagproject.feature.gallery.comment.CommentViewModel
import com.example.andibagproject.feature.gallery.viewmodel.SeeGalleryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val writeCommentModule = module {
    single { WriteCommentRepository() }
    viewModel { CommentViewModel(get()) }
}