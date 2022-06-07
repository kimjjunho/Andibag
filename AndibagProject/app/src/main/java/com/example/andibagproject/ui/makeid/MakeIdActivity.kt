package com.example.andibagproject.makeid

import android.graphics.Color
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityMakeIdBinding

class MakeIdActivity : AppCompatActivity() {
    private val TAG = "MakeIdActivity"

    private lateinit var mBinding : ActivityMakeIdBinding
    private val binding get() = mBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMakeIdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeBtn()

        mBinding.btnBack.setOnClickListener {
            finish()
        }
        mBinding.btnCheck.setOnClickListener {
            if(mBinding.etId.length()>0 && mBinding.etPassword.length()>0 && mBinding.etName.length()>0 && mBinding.etPasswordCheck.length()>0 && mBinding.etPassword.text.toString() == mBinding.etPasswordCheck.text.toString()){
                finish()
            }
        }
        mBinding.btnIdCheck.setOnClickListener {
            Toast.makeText(applicationContext,"사용 가능한 아이디 입니다!",Toast.LENGTH_LONG).show()
        }

    }

    private fun changeBtn(){
        mBinding.etName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(mBinding.etId.length()>0 && mBinding.etPassword.length()>0 && mBinding.etName.length()>0 && mBinding.etPasswordCheck.length()>0 && mBinding.etPassword.text.toString() == mBinding.etPasswordCheck.text.toString()){
                    mBinding.btnCheck.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.black))
                } else{
                    mBinding.btnCheck.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.gray))
                }
            }
        })
        mBinding.etId.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(mBinding.etId.length()>0){
                    mBinding.btnIdCheck.visibility = View.VISIBLE
                }else{
                    mBinding.btnIdCheck.visibility = View.INVISIBLE
                }
                if(mBinding.etId.length()>0 && mBinding.etPassword.length()>0 && mBinding.etName.length()>0 && mBinding.etPasswordCheck.length()>0 && mBinding.etPassword.text.toString() == mBinding.etPasswordCheck.text.toString()){
                    mBinding.btnCheck.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.black))
                } else{
                    mBinding.btnCheck.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.gray))
                }
            }
        })
        mBinding.etPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(mBinding.etPassword.text.toString() == mBinding.etPasswordCheck.text.toString()){
                    mBinding.tvWarning.visibility = View.INVISIBLE
                    if(mBinding.etId.length()>0 && mBinding.etPassword.length()>0 && mBinding.etName.length()>0 && mBinding.etPasswordCheck.length()>0){
                        mBinding.btnCheck.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.black))
                    }
                    else{
                        mBinding.btnCheck.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.gray))
                    }
                }
                else{
                    mBinding.tvWarning.visibility = View.VISIBLE
                    mBinding.btnCheck.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.gray))
                }

            }
        })
        mBinding.etPasswordCheck.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(mBinding.etPassword.text.toString() == mBinding.etPasswordCheck.text.toString()){
                    mBinding.tvWarning.visibility = View.INVISIBLE
                    if(mBinding.etId.length()>0 && mBinding.etPassword.length()>0 && mBinding.etName.length()>0 && mBinding.etPasswordCheck.length()>0){
                        mBinding.btnCheck.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.black))
                    }
                    else{
                        mBinding.btnCheck.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.gray))
                    }
                }
                else{
                    mBinding.tvWarning.visibility = View.VISIBLE
                    mBinding.btnCheck.setTextColor(ContextCompat.getColor(applicationContext!!,R.color.gray))
                }

            }
        })
    }
}