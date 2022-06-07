package com.example.andibagproject.ui.control

import com.example.andibagproject.R
import com.example.andibagproject.ui.base.BaseFragment
import com.example.andibagproject.databinding.FragmentControlBinding

class ControlFragment : BaseFragment<FragmentControlBinding>(R.layout.fragment_control) {
    override fun initView() {
        binding.run {
            controlSwitch.setOnClickListener {
                showToast("설정 변경됨")
            }
        }
    }

    override fun observeEvent() {}
}