package com.example.andibagproject.feature.friend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.size
import com.example.andibagproject.databinding.ActivitySearchBinding
import com.example.andibagproject.feature.friend.add.ui.AddFriendActivity

class SearchActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivitySearchBinding
    private val binding get() = mBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            imageBack.setOnClickListener {
                finish()
            }

            if(rv.size != 0){
                binding.layoutFindFriend.visibility = View.INVISIBLE
            }

            btnAddFriendPage.setOnClickListener {
                startActivity(Intent(applicationContext,AddFriendActivity::class.java))
                finish()
            }
        }
    }
}