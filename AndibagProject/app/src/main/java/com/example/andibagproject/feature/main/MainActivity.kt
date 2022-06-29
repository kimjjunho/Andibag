package com.example.andibagproject.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.andibagproject.R
import com.example.andibagproject.feature.chat.ChatFragment
import com.example.andibagproject.feature.control.ControlFragment
import com.example.andibagproject.databinding.ActivityMainBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.example.andibagproject.feature.commentgallery.CommentGalleryActivity
import com.example.andibagproject.feature.friend.load.ui.FriendFragment
import com.example.andibagproject.feature.gallery.main.ui.GalleryFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main), BottomNavigationView.OnNavigationItemSelectedListener {

    private var bottomNavigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*supportFragmentManager.beginTransaction().replace(R.id.main_frame, FriendFragment()).commit()
        mBinding.menuFriend.setImageResource(R.drawable.main_image_friend_black)*/

        bottomNavigationView = binding.mainBottomNavigation
        bottomNavigationView!!.setOnNavigationItemSelectedListener(this)
        bottomNavigationView!!.selectedItemId = R.id.menu_friend

        //moveFrag()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_friend ->{
                val friendFragment = FriendFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frame, friendFragment)
                    .commit()
                return true
            }
            R.id.menu_chat ->{
                val chatFragment = ChatFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frame, chatFragment)
                    .commit()
                return true
            }
            R.id.menu_gallery ->{
                val galleryFragment = GalleryFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frame, galleryFragment)
                    .commit()
                return true
            }
            R.id.menu_control ->{
                val controlFragment = ControlFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frame, controlFragment)
                    .commit()
                return true
            }
        }
        return false
    }

    /*private fun moveFrag(){
        mBinding.menuFriend.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_frame, FriendFragment())
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
    }*/

    fun finishActivity(){
        finish()
    }

    override fun observeEvent() {}
}