package com.example.andibagproject.ui.friend
import android.content.Intent
import com.example.andibagproject.ui.main.MainActivity
import com.example.andibagproject.R
import com.example.andibagproject.ui.base.BaseFragment
import com.example.andibagproject.databinding.FragmentFriendBinding

class FriendFragment : BaseFragment<FragmentFriendBinding>(R.layout.fragment_friend) {
    override fun initView() {
        val context = activity as MainActivity
        binding.run {
            imageSearch.setOnClickListener {
                startActivity(Intent(context,SearchActivity()::class.java))
            }
            imageAdd.setOnClickListener {
                startActivity(Intent(context,AddActivity()::class.java))
            }
        }
    }

    override fun observeEvent() {}
}