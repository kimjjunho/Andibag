package com.example.andibagproject.feature.friend
import android.content.Intent
import com.example.andibagproject.feature.main.MainActivity
import com.example.andibagproject.R
import com.example.andibagproject.feature.base.BaseFragment
import com.example.andibagproject.databinding.FragmentFriendBinding
import com.example.andibagproject.feature.friend.add.ui.AddFriendActivity

class FriendFragment : BaseFragment<FragmentFriendBinding>(R.layout.fragment_friend) {
    override fun initView() {
        val context = activity as MainActivity
        binding.run {
            imageSearch.setOnClickListener {
                startActivity(Intent(context,SearchActivity()::class.java))
            }
            imageAdd.setOnClickListener {
                startActivity(Intent(context, AddFriendActivity()::class.java))
            }
        }
    }

    override fun observeEvent() {}
}