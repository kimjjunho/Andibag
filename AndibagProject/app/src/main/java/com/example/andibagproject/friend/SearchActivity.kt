package com.example.andibagproject.friend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andibagproject.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivitySearchBinding
    private val binding get() = mBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageBack.setOnClickListener {
            finish()
        }
    }
}