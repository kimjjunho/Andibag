package com.example.andibagproject.di.module

import com.example.andibagproject.data.addfriend.AddFriendRepository
import com.example.andibagproject.feature.friend.add.viewmodel.AddFriendViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addFriendModule = module {
    single { AddFriendRepository() }
    viewModel { AddFriendViewModel(get()) }
}