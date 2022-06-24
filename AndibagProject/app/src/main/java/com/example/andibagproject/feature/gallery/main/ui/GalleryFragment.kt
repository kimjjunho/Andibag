package com.example.andibagproject.feature.gallery.main.ui

import android.content.Intent
import com.example.andibagproject.R
import com.example.andibagproject.databinding.FragmentGalleryBinding
import com.example.andibagproject.feature.base.BaseFragment
import com.example.andibagproject.feature.gallery.main.viewmodel.GalleryViewModel
import com.example.andibagproject.feature.makegallery.ui.MakeGalleryActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class GalleryFragment : BaseFragment<FragmentGalleryBinding>(R.layout.fragment_gallery) {
    val vm : GalleryViewModel by viewModel()

    override fun initView() {

        observeEvent()
        vm.seeGallery()

        binding.run {
            imageAdd.setOnClickListener {
                startActivity(Intent( context,MakeGalleryActivity::class.java))
            }

        }
    }

    override fun observeEvent() {
        vm.run {
            success.observe(this@GalleryFragment){
                it.run {
                    showToast("게시물 올리기 성공!")
                }
            }
            fail.observe(this@GalleryFragment){
                it.run {

                }
            }
        }
    }

}