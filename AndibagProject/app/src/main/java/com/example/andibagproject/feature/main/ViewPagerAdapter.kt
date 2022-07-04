package com.example.andibagproject.feature.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.andibagproject.feature.chat.ChatFragment
import com.example.andibagproject.feature.control.ControlFragment
import com.example.andibagproject.feature.friend.load.ui.FriendFragment
import com.example.andibagproject.feature.gallery.main.ui.GalleryFragment

class ViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 4
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FriendFragment()
            1-> ChatFragment()
            2 -> GalleryFragment()
            else -> ControlFragment()
        }
    }
}