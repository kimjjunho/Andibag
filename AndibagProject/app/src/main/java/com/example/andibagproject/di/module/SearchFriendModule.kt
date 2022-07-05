package com.example.andibagproject.di.module

import com.example.andibagproject.data.searchfriend.SearchFriendRepository
import com.example.andibagproject.feature.friend.search.viewmodel.SearchFriendViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchFriendModule = module {
    single { SearchFriendRepository() }
    viewModel { SearchFriendViewModel(get()) }
}