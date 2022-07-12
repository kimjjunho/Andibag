package com.example.andibagproject.feature.friend.add.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.andibagproject.ACCESS_TOKEN
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityAddFriendBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.example.andibagproject.feature.friend.add.model.AddFriendRequest
import com.example.andibagproject.feature.friend.add.viewmodel.AddFriendViewModel
import com.example.andibagproject.util.loadImage
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
                vm.loadFriend(AddFriendRequest(editText.text.toString()))
            }
            btnAddFriend.setOnClickListener {
                vm.addFriend(textPhoneNumber.text.toString())
            }
        }
    }

    override fun observeEvent(){
        vm.run {
            addSuccess.observe(this@AddFriendActivity) {
                showToastLong("친구 추가 성공")
            }
            addFail.observe(this@AddFriendActivity) {
                Log.d(TAG, "observeEvent: ")
                it.run {
                    when(it){
                        403 -> showToastShort("로그인을 다시해주세요")
                        401 -> showToastShort("로그인을 다시 하거나 자신의 번호를 입력한 것이 아닌지 확인해주세요")
                        400 -> showToastShort("형식에 알맞게 입력해 주새요")
                        404 -> showToastShort("찾는 번호가 존재하지 않습니다")
                    }
                }
            }

            loadId.observe(this@AddFriendActivity) {
                binding.textId.text = it.toString()
            }
            loadNickname.observe(this@AddFriendActivity) {
                binding.textName.text = it
                binding.textName.visibility = View.VISIBLE
                binding.btnAddFriend.visibility = View.VISIBLE
                binding.imageCard.visibility = View.VISIBLE
            }
            loadPhoneNumber.observe(this@AddFriendActivity){
                binding.textPhoneNumber.text = it
            }
            loadImageUrl.observe(this@AddFriendActivity){
                loadImage(binding.imageview,it)
            }
        }
    }
}