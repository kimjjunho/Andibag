package com.example.andibagproject.di.module

import com.example.andibagproject.data.gallery.comment.CommentRepository
import com.example.andibagproject.feature.gallery.comment.CommentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val commentModule = module {
    single { CommentRepository() }
    viewModel { CommentViewModel(get()) }
}