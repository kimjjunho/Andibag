package com.example.andibagproject

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.andibagproject.chat.ChatFragment
import com.example.andibagproject.control.ControlFragment
import com.example.andibagproject.databinding.ActivityMainBinding
import com.example.andibagproject.friend.FriendFragment
import com.example.andibagproject.gallery.GalleryFragment

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    private lateinit var mBinding : ActivityMainBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.main_frame, FriendFragment()).commit()
        mBinding.menuFriend.setImageResource(R.drawable.main_image_friend_black)
        moveFrag()

    }

    private fun moveFrag(){
        mBinding.menuFriend.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame,FriendFragment())
                .commit()
            imageSet()
            mBinding.menuFriend.setImageResource(R.drawable.main_image_friend_black)
        }
        mBinding.menuChat.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, ChatFragment())
                .commit()
            imageSet()
            mBinding.menuChat.setImageResource(R.drawable.main_image_chat_black)
        }
        mBinding.menuGrallery.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, GalleryFragment())
                .commit()
            imageSet()
            mBinding.menuGrallery.setImageResource(R.drawable.main_image_gallery_black)
        }
        mBinding.menuControl.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, ControlFragment())
                .commit()
            imageSet()
            mBinding.menuControl.setImageResource(R.drawable.main_image_control_black)
        }
    }

    private fun imageSet(){
        mBinding.menuFriend.setImageResource(R.drawable.main_image_friend)
        mBinding.menuChat.setImageResource(R.drawable.main_image_chat)
        mBinding.menuGrallery.setImageResource(R.drawable.main_image_gallery)
        mBinding.menuControl.setImageResource(R.drawable.main_image_control)
    }

}