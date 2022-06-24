package com.example.andibagproject.di.module

import com.example.andibagproject.data.gallery.reply.ReplyRepository
import com.example.andibagproject.feature.gallery.reply.ReplyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val replyModule = module {
    single { ReplyRepository() }
    viewModel { ReplyViewModel(get()) }
}