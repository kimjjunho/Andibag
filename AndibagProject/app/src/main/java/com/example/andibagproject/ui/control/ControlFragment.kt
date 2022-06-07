package com.example.andibagproject.control

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.andibagproject.R
import com.example.andibagproject.base.BaseFragment
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