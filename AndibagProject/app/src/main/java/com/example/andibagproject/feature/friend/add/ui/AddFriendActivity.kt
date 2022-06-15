package com.example.andibagproject.feature.friend.add.ui

import android.os.Bundle
import android.widget.Toast
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityAddFriendBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.example.andibagproject.feature.friend.add.model.AddFriendRequest
import com.example.andibagproject.feature.friend.add.viewmodel.AddFriendViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddFriendActivity : BaseActivity<ActivityAddFriendBinding>(R.layout.activity_add_friend) {
    val vm : AddFriendViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            imageBack.setOnClickListener {
                finish()
            }

            btnSearch.setOnClickListener {
                vm.addFriend(AddFriendRequest(editText.text.toString()))
            }
        }
    }

    override fun observeEvent(){
        vm.run {
            success.observe(this@AddFriendActivity) {
                it.run {
                    showToastLong("친구 추가 성공")
                }
            }
            fail.observe(this@AddFriendActivity) {
                it.run {
                    when(it){
                        403 -> showToastShort("로그인을 다시해주세요")
                        401 -> showToastShort("로그인을 다시 하거나 자신의 번호를 입력한 것이 아닌지 확인해주세요")
                        400 -> showToastShort("형식에 알맞게 입력해 주새요")
                        404 -> showToastShort("찾는 번호가 존재하지 않습니다")
                    }
                }
            }
        }
    }
}