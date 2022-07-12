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
import com.example.andibagproject.feature.main.MainActivity
import com.example.andibagproject.feature.settingDialogDelete
import java.util.*

class LoadFriendAdapter(private val recyclerView: RecyclerView, private val mainActivity: MainActivity): ListAdapter<LoadFriendResponse, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        LoadFriendViewHolder(
            ItemChattingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),recyclerView,mainActivity
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

class LoadFriendViewHolder(private val binding: ItemChattingBinding, private val recyclerView: RecyclerView, private val mainActivity: MainActivity):RecyclerView.ViewHolder(binding.root){
    fun bind(data: LoadFriendResponse){
        binding.userInfo = data
        binding.run {
            itemTextName.text = data.nickname

            itemBtnDelete.setOnClickListener {
                settingDialogDelete(mainActivity, itemTextName.text.toString()+"님을 친구에서 삭제하시겠습니까?") { helpDialog() }
            }
        }
    }

    private fun helpDialog(){
        (recyclerView.adapter as LoadFriendAdapter).removeItem(layoutPosition)
    }

    fun setAlpha(alpha: Float){
        with(binding){
            itemTextName.alpha = alpha
        }
    }
}