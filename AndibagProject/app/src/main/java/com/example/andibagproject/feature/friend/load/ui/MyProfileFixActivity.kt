package com.example.andibagproject.feature.friend.load.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityMyProfileFixBinding
import com.example.andibagproject.feature.base.BaseActivity

class MyProfileFixActivity : BaseActivity<ActivityMyProfileFixBinding>(R.layout.activity_my_profile_fix) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            imageBack.setOnClickListener {
                finish()
            }
        }

    }

    override fun observeEvent() {}
}