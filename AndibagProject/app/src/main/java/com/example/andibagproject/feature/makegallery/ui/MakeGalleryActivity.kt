package com.example.andibagproject.feature.makegallery.ui

import android.content.ContentValues
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityLoginBinding
import com.example.andibagproject.databinding.ActivityMakeGalleryBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.example.andibagproject.feature.login.viewmodel.LoginViewModel
import com.example.andibagproject.feature.makegallery.model.MakeGalleryRequest
import com.example.andibagproject.feature.makegallery.viewmodel.MakeGalleryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MakeGalleryActivity : BaseActivity<ActivityMakeGalleryBinding>(R.layout.activity_make_gallery) {
    val vm : MakeGalleryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeEvent()

        binding.run {
            btnSendMakeGallery.setOnClickListener {
                vm.makeGallery(MakeGalleryRequest(etTitleMakeGallery.text.toString(),etContentsMakeGallery.text.toString()))
            }
            imgBackMakeGallery.setOnClickListener {
                finish()
            }
        }

    }

    override fun observeEvent(){
        vm.run {
            success.observe(this@MakeGalleryActivity) {
                it.run {
                    showToastLong("게시물 올리기 성공!")
                    finish()
                }
            }
            fail.observe(this@MakeGalleryActivity) {
                it.run {
                    when(it){
                        403 -> showToastShort("다시 로그인 해주세요")
                        400 -> showToastShort("제목은 20글자 미만으로 작성해 주세요")
                        401 -> showToastShort("다시 로그인 해주세요")
                    }
                }
            }
        }
    }
}