package com.example.andibagproject.feature.friend.load.adapter

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.andibagproject.databinding.ItemChattingBinding
import com.example.andibagproject.feature.friend.load.model.LoadFriendResponse
import java.util.*

class LoadFriendAdapter(private val recyclerView: RecyclerView): ListAdapter<LoadFriendResponse, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        LoadFriendViewHolder(
            ItemChattingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),recyclerView
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is LoadFriendViewHolder){
            val data = getItem(position) as LoadFriendResponse
            holder.bind(data)
        }
    }

    fun removeItem(position: Int){
        val list = currentList.toMutableList()
        list.removeAt(position)
        submitList(list)
    }

    fun moveItem(fromPosition: Int, toPosition: Int){
        val list = currentList.toMutableList()
        Collections.swap(list, fromPosition, toPosition)
        submitList(list)
    }

    fun swapData(fromPos: Int, toPos: Int) {
        val list = currentList.toMutableList()
        Collections.swap(list, fromPos, toPos)
        notifyItemMoved(fromPos, toPos)
    }
}

class MyDiffCallback: DiffUtil.ItemCallback<LoadFriendResponse>(){
    override fun areItemsTheSame(oldItem: LoadFriendResponse, newItem: LoadFriendResponse): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: LoadFriendResponse, newItem: LoadFriendResponse): Boolean {
        return oldItem == newItem
    }

}

class LoadFriendViewHolder(private val binding: ItemChattingBinding, private val recyclerView: RecyclerView):RecyclerView.ViewHolder(binding.root){
    fun bind(data: LoadFriendResponse){
        binding.run {
            itemTextName.text = data.nickname

            itemBtnDelete.setOnClickListener {
                (recyclerView.adapter as LoadFriendAdapter).removeItem(layoutPosition)
            }

        }
    }

    fun setAlpha(alpha: Float){
        with(binding){
            itemTextName.alpha = alpha
        }
    }
}