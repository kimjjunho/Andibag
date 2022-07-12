package com.example.andibagproject.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.andibagproject.R

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, url: String?) {
    imageView.clipToOutline = true //imageView background 적용을 위한 속성
    Glide.with(imageView)
        .load(url)
        .error(R.drawable.item_image_profile)
        .into(imageView)
}
