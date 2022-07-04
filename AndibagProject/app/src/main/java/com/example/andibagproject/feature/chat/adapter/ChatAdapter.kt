package com.example.andibagproject.feature.chat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.andibagproject.R
import com.example.andibagproject.feature.friend.load.model.LoadFriendResponse

class ChatAdapter(private val chatList:ArrayList<LoadFriendResponse>):RecyclerView.Adapter<ChatAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //val view = ItemChatingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val subView = LayoutInflater.from(parent.context).inflate(R.layout.item_chatting,parent,false)
        return CustomViewHolder(subView)
    }

    override fun onBindViewHolder(holder: ChatAdapter.CustomViewHolder, position: Int) {
        val list = chatList[position]
        holder.apply { bind(list) }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    class CustomViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val useView = view
        val itemTextName : TextView = useView.findViewById(R.id.item_text_name)

        fun bind(list: LoadFriendResponse){
            itemTextName.text = list.nickname
        }
    }
}