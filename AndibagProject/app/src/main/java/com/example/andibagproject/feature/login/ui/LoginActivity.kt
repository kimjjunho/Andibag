package com.example.andibagproject.feature.login.ui

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.andibagproject.feature.main.MainActivity
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityLoginBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.example.andibagproject.feature.login.model.LoginRequest
import com.example.andibagproject.feature.login.viewmodel.LoginViewModel
import com.example.andibagproject.feature.makeid.ui.MakeIdActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    val vm : LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeEvent()
        changeBtn()

        binding.run {
            btnMakeId.setOnClickListener {
                startActivity(Intent(applicationContext, MakeIdActivity::class.java))
            }
            btnLogin.setOnClickListener {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                vm.login(LoginRequest(etId.text.toString(),etPassword.text.toString()))
            }
        }
    }

    override fun observeEvent(){
        vm.run {
            success.observe(this@LoginActivity) {
                it.run {
                    if (binding.etId.length() > 0 && binding.etPassword.length() > 0) {
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                        finish()
                    }
                }
            }
            fail.observe(this@LoginActivity) {
                it.run {
                    when (it) {
                        401 -> Toast.makeText(applicationContext,"비밀번호가 일치하지 않습니다",Toast.LENGTH_SHORT).show()
                        404 -> Toast.makeText(applicationContext,"해당 id가 존재하지 않습니다",Toast.LENGTH_SHORT).show()
                        500 -> Toast.makeText(applicationContext, "서버가 닫혀 있습니다", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun changeBtn(){
        binding.etId.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(binding.etId.length()>0 && binding.etPassword.length()>0){
                    binding.btnLogin.setBackgroundResource(R.drawable.login_btn_on)
                } else{
                    binding.btnLogin.setBackgroundResource(R.drawable.login_btn_off)
                }
            }
        })
        binding.etPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(binding.etId.length()>0 && binding.etPassword.length()>0){
                    binding.btnLogin.setBackgroundResource(R.drawable.login_btn_on)
                } else{
                    binding.btnLogin.setBackgroundResource(R.drawable.login_btn_off)
                }
            }
        })
    }
}