package com.example.andibagproject.di.module

import com.example.andibagproject.data.loadfriend.LoadFriendRepository
import com.example.andibagproject.feature.friend.load.viewmodel.FriendViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loadFriendModule = module {
    single { LoadFriendRepository() }
    viewModel { FriendViewModel(get()) }
}