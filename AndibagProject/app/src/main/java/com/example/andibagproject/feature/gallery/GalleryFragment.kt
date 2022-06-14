package com.example.andibagproject.feature.gallery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.andibagproject.R
import com.example.andibagproject.databinding.FragmentGalleryBinding
import com.example.andibagproject.feature.base.BaseFragment
import com.example.andibagproject.feature.makegallery.ui.MakeGalleryActivity

class GalleryFragment : BaseFragment<FragmentGalleryBinding>(R.layout.fragment_gallery) {
    override fun initView() {
        binding.run {
            imageAdd.setOnClickListener {
                startActivity(Intent( context,MakeGalleryActivity::class.java))
            }
            btnAllCheckGallery.setOnClickListener {
                
            }
        }
    }

    override fun observeEvent() {}

}