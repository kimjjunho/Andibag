package com.example.andibagproject.handler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityErrorBinding
import com.example.andibagproject.feature.login.ui.LoginActivity

class ErrorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityErrorBinding

    private val lastActivityIntent by lazy { intent.getParcelableExtra<Intent>(EXTRA_ERROR_TEXT) }
    private val errorText by lazy { intent.getStringExtra(EXTRA_ERROR_TEXT) }

    private var errorCheckState: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_error)

        binding.run {
            btnLoginError.setOnClickListener {
                startActivity(Intent(applicationContext,LoginActivity::class.java))
                finish()
            }
            btnBackError.setOnClickListener {
                startActivity(lastActivityIntent)
                finish()
            }
        }
    }

    companion object{
        const val EXTRA_INTENT = "EXTRA_INTENT"
        const val EXTRA_ERROR_TEXT = "EXTRA_ERROR_TEXT"
    }
}