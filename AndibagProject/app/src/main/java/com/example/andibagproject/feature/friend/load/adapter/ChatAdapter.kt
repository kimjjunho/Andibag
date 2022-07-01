package com.example.andibagproject.feature.friend.load.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ItemChatingBinding
import com.example.andibagproject.feature.friend.load.model.LoadFriendResponse

class ChatAdapter(private val chatList:ArrayList<LoadFriendResponse>):RecyclerView.Adapter<ChatAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.CustomViewHolder {
        val view = ItemChatingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val subView = LayoutInflater.from(parent.context).inflate(R.layout.item_chating,parent,false)
        return CustomViewHolder(view,subView)
    }

    override fun onBindViewHolder(holder: ChatAdapter.CustomViewHolder, position: Int) {
        val list = chatList[position]
        holder.apply { bind(list) }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    class CustomViewHolder(itemView: ItemChatingBinding, subView: View):RecyclerView.ViewHolder(subView) {
        val view = itemView
        fun bind(list: LoadFriendResponse){
            view.textItemName.text = list.nickname
        }
    }
}