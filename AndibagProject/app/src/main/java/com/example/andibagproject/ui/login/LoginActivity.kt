package com.example.andibagproject.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.andibagproject.ui.main.MainActivity
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityLoginBinding
import com.example.andibagproject.ui.makeid.MakeIdActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityLoginBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeBtn()

        mBinding.btnMakeId.setOnClickListener {
            startActivity(Intent(applicationContext, MakeIdActivity::class.java))
        }
        mBinding.btnLogin.setOnClickListener {
            if(mBinding.etId.length()>0 && mBinding.etPassword.length()>0){
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }
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