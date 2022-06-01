package com.example.andibagproject.friend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityAddBinding
import com.example.andibagproject.databinding.ActivityLoginBinding

class AddActivity : AppCompatActivity() {

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