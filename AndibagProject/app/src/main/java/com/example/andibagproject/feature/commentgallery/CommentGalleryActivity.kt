package com.example.andibagproject.feature.commentgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityCommentGalleryBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.sothree.slidinguppanel.SlidingUpPanelLayout

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
        }
    }

    override fun observeEvent() {}
}