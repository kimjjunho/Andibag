package com.example.andibagproject.feature.chat

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andibagproject.R
import com.example.andibagproject.databinding.FragmentChatBinding
import com.example.andibagproject.feature.base.BaseFragment
import com.example.andibagproject.feature.chat.adapter.ChatAdapter
import com.example.andibagproject.feature.friend.load.model.LoadFriendResponse

class ChatFragment : BaseFragment<FragmentChatBinding>(R.layout.fragment_chat) {

    private val chatAdapter : ChatAdapter by lazy {
        ChatAdapter(chatList)
    }
    private val chatList = arrayListOf<LoadFriendResponse>().apply {
        add(LoadFriendResponse(1,"nickname","01012345678"))
        add(LoadFriendResponse(1,"nickname","01012345678"))
    }
    override fun initView() {
        binding.run {

            rv.apply {
                adapter = chatAdapter
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                setHasFixedSize(true)
            }

        }

    }

    override fun observeEvent() {}


}