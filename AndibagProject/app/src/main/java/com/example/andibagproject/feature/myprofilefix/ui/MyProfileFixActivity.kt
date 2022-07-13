package com.example.andibagproject.feature.myprofilefix.ui

import android.os.Bundle
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityMyProfileFixBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.example.andibagproject.feature.myprofilefix.model.MyProfileFixRequest
import com.example.andibagproject.feature.myprofilefix.viewmodel.MyProfileFixViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyProfileFixActivity : BaseActivity<ActivityMyProfileFixBinding>(R.layout.activity_my_profile_fix) {

    private val vm : MyProfileFixViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            imageBack.setOnClickListener {
                finish()
            }
            btnFix.setOnClickListener {
                vm.myProfileFix(MyProfileFixRequest("dfn", "","01072747217"))
            }
        }

    }

    override fun observeEvent() {
        vm.run {
            success.observe(this@MyProfileFixActivity){
                showToastShort("프로필 수정을 성공하셨습니다.")
                finish()
            }
            fail.observe(this@MyProfileFixActivity) {
                when(it){
                    401, 403 -> showToastShort("다시 로그인 해주세요")
                    400 -> showToastShort("형식에 알맞게 작성해 주세요")
                    409 -> showToastShort("이미 있는 핸드폰 번호입니다")
                }
            }
        }
    }
}