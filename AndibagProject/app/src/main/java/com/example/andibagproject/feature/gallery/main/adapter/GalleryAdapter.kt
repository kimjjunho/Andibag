package com.example.andibagproject.feature.gallery.main.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityMainBinding
import com.example.andibagproject.databinding.FragmentGalleryBinding
import com.example.andibagproject.feature.gallery.main.model.SeeGalleryResponse
import com.example.andibagproject.feature.gallery.main.ui.GalleryFragment
import com.example.andibagproject.feature.main.MainActivity

class GalleryAdapter(private val arrayList: ArrayList<SeeGalleryResponse>, private val binding: GalleryFragment):RecyclerView.Adapter<GalleryAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.name.text = arrayList[position].name
        holder.apply { click(binding) }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.item_text_name)

        fun click(binding: GalleryFragment){
            itemView.setOnClickListener {
                binding.startCommentGallery()
            }
        }
    }
}