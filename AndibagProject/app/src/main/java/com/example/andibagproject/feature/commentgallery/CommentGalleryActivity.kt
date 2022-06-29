package com.example.andibagproject.feature.commentgallery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityCommentGalleryBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import org.koin.android.ext.android.bind

class CommentGalleryActivity : BaseActivity<ActivityCommentGalleryBinding>(R.layout.activity_comment_gallery) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeEvent()

        binding.run {
            imageBack.setOnClickListener {
                finish()
            }
            imgChat.setOnClickListener {
                binding.mainFrame.panelState = SlidingUpPanelLayout.PanelState.ANCHORED
            }

            textTitle.text = intent.getStringExtra("title")
            textContent.text = intent.getStringExtra("content")
        }
    }

    override fun observeEvent() {}
}