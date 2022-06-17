package com.example.andibagproject.feature.friend.load.ui
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.andibagproject.feature.main.MainActivity
import com.example.andibagproject.R
import com.example.andibagproject.databinding.FragmentFriendBinding
import com.example.andibagproject.feature.base.BaseFragment
import com.example.andibagproject.feature.friend.SearchActivity
import com.example.andibagproject.feature.friend.add.ui.AddFriendActivity
import com.example.andibagproject.feature.friend.load.viewmodel.FriendViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FriendFragment : BaseFragment<FragmentFriendBinding>(R.layout.fragment_friend) {
    val vm : FriendViewModel by viewModel()

    override fun initView() {
        val context = activity as MainActivity
        //vm.loadFriend()
        binding.run {
            imageSearch.setOnClickListener {
                startActivity(Intent(context, SearchActivity()::class.java))
            }
            imageAdd.setOnClickListener {
                startActivity(Intent(context, AddFriendActivity()::class.java))
            }
        }
    }

    override fun observeEvent() {
        vm.run {
            success.observe(this@FriendFragment){
                it.run {
                    Log.d(TAG, "observeEvent: $it")
                }
            }
            fail.observe(this@FriendFragment){
                it.run {
                    when(it){
                        401,403 -> showToast("다시 로그인 해주세요")
                    }
                }
            }
        }
    }
}