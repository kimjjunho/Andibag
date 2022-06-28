package com.example.andibagproject.feature.control

import android.content.Intent
import com.example.andibagproject.R
import com.example.andibagproject.feature.base.BaseFragment
import com.example.andibagproject.databinding.FragmentControlBinding
import com.example.andibagproject.feature.login.ui.LoginActivity
import com.example.andibagproject.feature.main.MainActivity

class ControlFragment : BaseFragment<FragmentControlBinding>(R.layout.fragment_control) {
    override fun initView() {

        val mainActivity = activity as MainActivity

        binding.run {
            controlSwitch.setOnClickListener {
                showToast("설정 변경됨")
            }
            btnLogout.setOnClickListener {
                startActivity(Intent(activity,LoginActivity::class.java))
                mainActivity.finishActivity()
            }
        }
    }

    override fun observeEvent() {}
}