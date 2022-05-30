package com.example.andibagproject.friend
import android.content.Intent
import com.example.andibagproject.MainActivity
import com.example.andibagproject.R
import com.example.andibagproject.base.BaseFragment
import com.example.andibagproject.databinding.FragmentFriendBinding

class FriendFragment : BaseFragment<FragmentFriendBinding>(R.layout.fragment_friend) {
    override fun initView() {
        val context = activity as MainActivity
        binding.run {
            imageSearch.setOnClickListener {
                startActivity(Intent(context,SearchActivity()::class.java))
            }
        }
    }

    override fun observeEvent() {}
}