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
import com.example.andibagproject.feature.login.viewmodel.LoginViewModel
import com.example.andibagproject.feature.makegallery.model.MakeGalleryRequest
import com.example.andibagproject.feature.makegallery.viewmodel.MakeGalleryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MakeGalleryActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMakeGalleryBinding
    private val binding get() = mBinding
    val vm : MakeGalleryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMakeGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeEvent()

        mBinding.run {
            btnSendMakeGallery.setOnClickListener {
                vm.makeGallery(MakeGalleryRequest(etTitleMakeGallery.text.toString(),etContentsMakeGallery.text.toString()))
            }
            imgBackMakeGallery.setOnClickListener {
                finish()
            }
        }

    }

    private fun observeEvent(){
        vm.run {
            success.observe(this@MakeGalleryActivity,{
                it.run {
                    Log.d(TAG, "success: ")
                }
            })
            fail.observe(this@MakeGalleryActivity,{
                it.run {
                    Log.d(TAG, "fail: $it")
                    Log.d(TAG, ACCESS_TOKEN)
                }
            })
        }
    }
}