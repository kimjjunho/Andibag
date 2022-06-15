package com.example.andibagproject.feature.friend.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andibagproject.databinding.ActivityAddBinding

class AddFriendActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityAddBinding
    private val binding get() = mBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageBack.setOnClickListener {
            finish()
        }
    }
}