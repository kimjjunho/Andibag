package com.example.andibagproject.feature.login.ui

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.example.andibagproject.feature.main.MainActivity
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityLoginBinding
import com.example.andibagproject.feature.login.model.LoginRequest
import com.example.andibagproject.feature.login.viewmodel.LoginViewModel
import com.example.andibagproject.feature.makeid.ui.MakeIdActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityLoginBinding
    private val binding get() = mBinding
    val vm : LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeEvent()
        changeBtn()

        mBinding.btnMakeId.setOnClickListener {
            startActivity(Intent(applicationContext, MakeIdActivity::class.java))
        }
        mBinding.btnLogin.setOnClickListener {
            if(mBinding.etId.length()>0 && mBinding.etPassword.length()>0){
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }
            vm.login(LoginRequest("jaemin05","sasd"))
        }

    }

    private fun observeEvent(){
        vm.run {
            success.observe(this@LoginActivity,{
                it.run {
                    Log.d(TAG, "success: ")
                }
            })
            fail.observe(this@LoginActivity,{
                it.run {
                    Log.d(TAG, "fail: ")
                }
            })
        }
    }

    private fun changeBtn(){
        mBinding.etId.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(mBinding.etId.length()>0 && mBinding.etPassword.length()>0){
                    mBinding.btnLogin.setBackgroundResource(R.drawable.login_btn_on)
                } else{
                    mBinding.btnLogin.setBackgroundResource(R.drawable.login_btn_off)
                }
            }
        })
        mBinding.etPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(mBinding.etId.length()>0 && mBinding.etPassword.length()>0){
                    mBinding.btnLogin.setBackgroundResource(R.drawable.login_btn_on)
                } else{
                    mBinding.btnLogin.setBackgroundResource(R.drawable.login_btn_off)
                }
            }
        })
    }
}