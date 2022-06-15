package com.example.andibagproject.feature.login.ui

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.andibagproject.feature.main.MainActivity
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityLoginBinding
import com.example.andibagproject.feature.login.model.LoginRequest
import com.example.andibagproject.feature.login.viewmodel.LoginViewModel
import com.example.andibagproject.feature.makeid.ui.MakeIdActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

   /* private lateinit var mBinding : ActivityLoginBinding
    private val binding get() = mBinding*/
    private lateinit var mBinding: ActivityLoginBinding
    val vm : LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)*/

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        observeEvent()
        changeBtn()

        mBinding.btnMakeId.setOnClickListener {
            startActivity(Intent(applicationContext, MakeIdActivity::class.java))
        }
        mBinding.btnLogin.setOnClickListener {
            vm.login(LoginRequest("junho0505","sasdsd"))
            //throw RuntimeException("Test Exception")
        }

    }

    private fun observeEvent(){
        vm.run {
            success.observe(this@LoginActivity) {
                it.run {
                    if (mBinding.etId.length() > 0 && mBinding.etPassword.length() > 0) {
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                        finish()
                    }
                }
            }
            fail.observe(this@LoginActivity) {
                it.run {
                    when (it) {
                        500 -> Toast.makeText(applicationContext, "서버가 닫혀 있습니다", Toast.LENGTH_SHORT).show()
                    }
                }
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