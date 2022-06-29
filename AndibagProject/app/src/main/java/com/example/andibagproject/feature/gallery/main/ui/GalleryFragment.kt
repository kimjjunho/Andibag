package com.example.andibagproject.feature.gallery.main.ui

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andibagproject.R
import com.example.andibagproject.databinding.FragmentGalleryBinding
import com.example.andibagproject.feature.base.BaseFragment
import com.example.andibagproject.feature.commentgallery.CommentGalleryActivity
import com.example.andibagproject.feature.gallery.main.adapter.GalleryAdapter
import com.example.andibagproject.feature.gallery.main.model.SeeGalleryCategory
import com.example.andibagproject.feature.gallery.main.model.SeeGalleryResponse
import com.example.andibagproject.feature.gallery.main.viewmodel.GalleryViewModel
import com.example.andibagproject.feature.main.MainActivity
import com.example.andibagproject.feature.makegallery.ui.MakeGalleryActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class GalleryFragment : BaseFragment<FragmentGalleryBinding>(R.layout.fragment_gallery) {
    val vm : GalleryViewModel by viewModel()

    private val galleryNewList = arrayListOf<SeeGalleryResponse>().apply{
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문은소"))
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문은소"))
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문은소"))
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문은소"))
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문은소"))
    }

    private val galleryFriendList = arrayListOf<SeeGalleryResponse>().apply {
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문혜원"))
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문혜원"))
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문혜원"))
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문혜원"))
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문혜원"))
    }

    private val galleryGoodList = arrayListOf<SeeGalleryResponse>().apply {
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문은소 vs 문혜원"))
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문은소 vs 문혜원"))
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문은소 vs 문혜원"))
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문은소 vs 문혜원"))
        add(SeeGalleryResponse(0,"title","content","2022-06-29","2022-06-29,","문은소 vs 문혜원"))
    }

    override fun initView() {

        observeEvent()
        vm.seeGallery(SeeGalleryCategory.GOOD)
        vm.seeGallery(SeeGalleryCategory.FRIEND)
        vm.seeGallery(SeeGalleryCategory.NEW)

        binding.run {
            imageAdd.setOnClickListener {
                startActivity(Intent( context,MakeGalleryActivity::class.java))
            }

            rv1.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
            rv1.setHasFixedSize(true)

            rv2.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
            rv2.setHasFixedSize(true)

            rv3.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
            rv3.setHasFixedSize(true)
        }
    }

    override fun observeEvent() {
        vm.run {
            success.observe(this@GalleryFragment){
                it.run {
                    showToast("게시물 보기 성공!")
                }
            }
            fail.observe(this@GalleryFragment){
                it.run {

                }
            }
        }
    }

    fun startCommentGallery() {
        startActivity(Intent(context, CommentGalleryActivity::class.java))
    }

    override fun onResume() {
        super.onResume()

        binding.run {
            rv1.adapter = GalleryAdapter(galleryNewList, this@GalleryFragment)
            rv2.adapter = GalleryAdapter(galleryFriendList, this@GalleryFragment)
            rv3.adapter = GalleryAdapter(galleryGoodList, this@GalleryFragment)

        }
    }

}