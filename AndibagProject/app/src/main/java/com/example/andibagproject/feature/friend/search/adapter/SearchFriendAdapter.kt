package com.example.andibagproject.feature.friend.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.andibagproject.databinding.ItemFriendSearchBinding
import com.example.andibagproject.feature.friend.search.model.SearchFriendResponse
import java.util.*

class  SearchFriendAdapter(private val recyclerView: RecyclerView) : ListAdapter<SearchFriendResponse, RecyclerView.ViewHolder>(MyDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        SearchFriendViewHolder(
            ItemFriendSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), recyclerView
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is SearchFriendViewHolder){
            val binding = getItem(position) as SearchFriendResponse
            holder.bind(binding,)
        }
    }

    fun removeItem(position: Int){
        val list = currentList.toMutableList()
        list.removeAt(position)
        submitList(list)
    }

    fun removeAll(){
        val list = currentList.toMutableList()
        list.clear()
        submitList(list)
    }


}

class MyDiffCallback : DiffUtil.ItemCallback<SearchFriendResponse>(){
    override fun areItemsTheSame(oldItem: SearchFriendResponse, newItem: SearchFriendResponse): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: SearchFriendResponse, newItem: SearchFriendResponse): Boolean {
        return oldItem == newItem
    }
}

class SearchFriendViewHolder(private val binding: ItemFriendSearchBinding, private val recyclerView: RecyclerView) : RecyclerView.ViewHolder(binding.root){
    fun bind(data: SearchFriendResponse){
        binding.run {
            itemTextName.text = data.name

            itemImgDelete.setOnClickListener {
                (recyclerView.adapter as SearchFriendAdapter).removeItem(layoutPosition)
            }
        }

    }

    fun setAlpha(alpha: Float){
        binding.run {
            itemTextName.alpha = alpha
        }
    }
}