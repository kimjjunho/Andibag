package com.example.andibagproject.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.andibagproject.R
import com.example.andibagproject.feature.chat.ChatFragment
import com.example.andibagproject.feature.control.ControlFragment
import com.example.andibagproject.databinding.ActivityMainBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.example.andibagproject.feature.commentgallery.CommentGalleryActivity
import com.example.andibagproject.feature.friend.load.ui.FriendFragment
import com.example.andibagproject.feature.gallery.main.ui.GalleryFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.android.bind

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main), BottomNavigationView.OnNavigationItemSelectedListener {

    private var bottomNavigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*supportFragmentManager.beginTransaction().replace(R.id.main_frame, FriendFragment()).commit()
        mBinding.menuFriend.setImageResource(R.drawable.main_image_friend_black)*/

        binding.pager.adapter = ViewPagerAdapter(this)

        binding.pager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.mainBottomNavigation.menu.getItem(position).isChecked = true
                }
            }
        )

        binding.mainBottomNavigation.setOnNavigationItemSelectedListener(this)


        bottomNavigationView = binding.mainBottomNavigation
        bottomNavigationView!!.setOnNavigationItemSelectedListener(this)
        bottomNavigationView!!.selectedItemId = R.id.menu_friend

        //moveFrag()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_friend ->{
                binding.pager.currentItem = 0
                return true
            }
            R.id.menu_chat ->{
                binding.pager.currentItem = 1
                return true
            }
            R.id.menu_gallery ->{
                binding.pager.currentItem = 2
                return true
            }
            R.id.menu_control ->{
                binding.pager.currentItem = 3
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