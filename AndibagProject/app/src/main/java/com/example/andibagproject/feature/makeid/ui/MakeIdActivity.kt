package com.example.andibagproject.feature.makeid.ui

import android.app.AlertDialog
import android.content.Intent
import android.graphics.ImageDecoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityMakeIdBinding
import com.example.andibagproject.feature.image.LoadImageAddressRequest
import com.example.andibagproject.feature.image.LoadImageAddressViewModel
import com.example.andibagproject.feature.makeid.model.CheckIdRequest
import com.example.andibagproject.feature.makeid.model.MakeIdRequest
import com.example.andibagproject.feature.makeid.viewmodel.MakeIdViewModel
import com.example.andibagproject.util.uriToMultipart
import okhttp3.MultipartBody
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.log

class MakeIdActivity : AppCompatActivity() {
    private val TAG = "MakeIdActivity"

    private lateinit var mBinding: ActivityMakeIdBinding
    private val binding get() = mBinding

    val vm: MakeIdViewModel by viewModel()
    val imageVm: LoadImageAddressViewModel by viewModel()

    private var body: MultipartBody.Part? = null

    //private var imageUri : String? = null
    private var imageList = listOf<String>()

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMakeIdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeBtn()
        observeEvent()

        mBinding.run {
            btnBack.setOnClickListener {
                finish()
            }

            btnCheck.setOnClickListener {

                if (etId.length() > 0 && etPassword.length() > 0 && etName.length() > 0 && etPasswordCheck.length() > 0 && etPassword.text.toString() == etPasswordCheck.text.toString() && etPhone.length() == 11) {
                    if (body == null) {
                        vm.makeId(
                            MakeIdRequest(
                                etName.text.toString(),
                                etId.text.toString(),
                                etPassword.text.toString(),
                                etPhone.text.toString(),
                                null
                            )
                        )
                    } else {
                        imageVm.loadImageAddress(body!!)
                    }
                } else {
                    toastShort("모든 항목을 조건에 맞게 작성해 주세요.")
                }
            }
            btnIdCheck.setOnClickListener {
                vm.checkId(CheckIdRequest(etId.text.toString()))
            }

            imageButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type = "image/*"
                filterActivityLauncher.launch(intent)

            }

            imageButton.setOnLongClickListener {
                imageButton.setImageResource(R.drawable.makeid_profileimage)
                body = null

                return@setOnLongClickListener(true)
            }
        }
    }

    private val filterActivityLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK && it.data != null) {
                val currentImageUri = it.data?.data
                try {
                    currentImageUri?.let {
                        if (Build.VERSION.SDK_INT < 28) {
                            val bitmap = MediaStore.Images.Media.getBitmap(
                                this.contentResolver,
                                currentImageUri
                            )
                            binding.imageButton.setImageBitmap(bitmap)

                            body = uriToMultipart(
                                this,
                                currentImageUri.path.toString(), currentImageUri
                            )

                        } else {
                            val source =
                                ImageDecoder.createSource(this.contentResolver, currentImageUri)
                            val bitmap = ImageDecoder.decodeBitmap(source)
                            binding.imageButton.setImageBitmap(bitmap)

                            body = uriToMultipart(
                                this,
                                currentImageUri.path.toString(), currentImageUri
                            )
                            Log.d(TAG, "uri: $currentImageUri")
                            Log.d(TAG, "body: $body")
                            Log.d(TAG, "path: " + currentImageUri.path)
                        }
                    }


                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else if (it.resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            } else {
                Log.d("ActivityResult", "something wrong")
            }
        }

    private fun observeEvent() {
        vm.run {
            success.observe(this@MakeIdActivity) {
                it.run {
                    toastLong("회원가입에 성공하셨습니다!")
                    finish()
                }
            }
            fail.observe(this@MakeIdActivity) {
                it.run {
                    when (it) {
                        409 -> toastShort("해당 id가 이미 존재합니다.")
                        400 -> toastShort("공백 혹은 띄어쓰기가 존재합니다.")
                    }
                }
            }
            idCheck.observe(this@MakeIdActivity) {
                it.run {
                    when (it) {
                        202 -> toastShort("사용 가능한 아이디입니다")
                        409 -> toastShort("해당 아이디가 이미 존재합니다")
                        else -> Log.d(TAG, "observeEvent: $it")
                    }
                }
            }
        }

        imageVm.run {
            fileList.observe(this@MakeIdActivity) {
                Log.d(TAG, "observeEvent: fileList")
                imageList = it.image

                vm.makeId(
                    MakeIdRequest(
                        binding.etName.text.toString(),
                        binding.etId.text.toString(),
                        binding.etPassword.text.toString(),
                        binding.etPhone.text.toString(),
                        imageList[0]
                    )
                )
            }
            fail.observe(this@MakeIdActivity) {
                Log.d(TAG, "observeEvent: $it")
                when (it) {
                    //404 -> toastShort("사진이 비어있음")
                    400 -> toastShort("사진 용량이 너무 큽니다")
                }
            }
        }
    }

    private fun changeBtn() {
        mBinding.etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (mBinding.etId.length() > 0 && mBinding.etPassword.length() > 0 && mBinding.etName.length() > 0 && mBinding.etPasswordCheck.length() > 0 && mBinding.etPassword.text.toString() == mBinding.etPasswordCheck.text.toString()) {
                    mBinding.btnCheck.setTextColor(
                        ContextCompat.getColor(
                            applicationContext!!,
                            R.color.black
                        )
                    )
                } else {
                    mBinding.btnCheck.setTextColor(
                        ContextCompat.getColor(
                            applicationContext!!,
                            R.color.gray
                        )
                    )
                }
            }
        })
        mBinding.etId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (mBinding.etId.length() > 0) {
                    mBinding.btnIdCheck.visibility = View.VISIBLE
                } else {
                    mBinding.btnIdCheck.visibility = View.INVISIBLE
                }
                if (mBinding.etId.length() > 0 && mBinding.etPassword.length() > 0 && mBinding.etName.length() > 0 && mBinding.etPasswordCheck.length() > 0 && mBinding.etPassword.text.toString() == mBinding.etPasswordCheck.text.toString()) {
                    mBinding.btnCheck.setTextColor(
                        ContextCompat.getColor(
                            applicationContext!!,
                            R.color.black
                        )
                    )
                } else {
                    mBinding.btnCheck.setTextColor(
                        ContextCompat.getColor(
                            applicationContext!!,
                            R.color.gray
                        )
                    )
                }
            }
        })
        mBinding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (mBinding.etPassword.text.toString() == mBinding.etPasswordCheck.text.toString()) {
                    mBinding.tvWarning.visibility = View.INVISIBLE
                    if (mBinding.etId.length() > 0 && mBinding.etPassword.length() > 0 && mBinding.etName.length() > 0 && mBinding.etPasswordCheck.length() > 0) {
                        mBinding.btnCheck.setTextColor(
                            ContextCompat.getColor(
                                applicationContext!!,
                                R.color.black
                            )
                        )
                    } else {
                        mBinding.btnCheck.setTextColor(
                            ContextCompat.getColor(
                                applicationContext!!,
                                R.color.gray
                            )
                        )
                    }
                } else {
                    mBinding.tvWarning.visibility = View.VISIBLE
                    mBinding.btnCheck.setTextColor(
                        ContextCompat.getColor(
                            applicationContext!!,
                            R.color.gray
                        )
                    )
                }

            }
        })
        mBinding.etPasswordCheck.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (mBinding.etPassword.text.toString() == mBinding.etPasswordCheck.text.toString()) {
                    mBinding.tvWarning.visibility = View.INVISIBLE
                    if (mBinding.etId.length() > 0 && mBinding.etPassword.length() > 0 && mBinding.etName.length() > 0 && mBinding.etPasswordCheck.length() > 0) {
                        mBinding.btnCheck.setTextColor(
                            ContextCompat.getColor(
                                applicationContext!!,
                                R.color.black
                            )
                        )
                    } else {
                        mBinding.btnCheck.setTextColor(
                            ContextCompat.getColor(
                                applicationContext!!,
                                R.color.gray
                            )
                        )
                    }
                } else {
                    mBinding.tvWarning.visibility = View.VISIBLE
                    mBinding.btnCheck.setTextColor(
                        ContextCompat.getColor(
                            applicationContext!!,
                            R.color.gray
                        )
                    )
                }

            }
        })
    }

    private fun toastShort(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
    }

    private fun toastLong(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
    }
}