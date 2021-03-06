package com.example.andibagproject.feature.myprofilefix.ui

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivityMyProfileFixBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.example.andibagproject.feature.image.LoadImageAddressViewModel
import com.example.andibagproject.feature.myprofilefix.model.MyProfileFixRequest
import com.example.andibagproject.feature.myprofilefix.viewmodel.MyProfileFixViewModel
import com.example.andibagproject.util.uriToMultipart
import okhttp3.MultipartBody
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyProfileFixActivity : BaseActivity<ActivityMyProfileFixBinding>(R.layout.activity_my_profile_fix) {

    private val vm : MyProfileFixViewModel by viewModel()
    private val imageUrlVm : LoadImageAddressViewModel by viewModel()
    private var body : MultipartBody.Part? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            imageBack.setOnClickListener {
                finish()
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

            btnFix.setOnClickListener {
                if(body == null){
                    vm.myProfileFix(MyProfileFixRequest(editChangeName.text.toString(), null,editChangePhoneNumber.text.toString()))
                }else{
                    imageUrlVm.loadImageAddress(body!!)
                }
            }
        }

    }

    override fun observeEvent() {
        vm.run {
            success.observe(this@MyProfileFixActivity){
                showToastShort("????????? ????????? ?????????????????????.")
                finish()
            }
            fail.observe(this@MyProfileFixActivity) {
                when(it){
                    401, 403 -> showToastShort("?????? ????????? ????????????")
                    400 -> showToastShort("????????? ????????? ????????? ?????????")
                    409 -> showToastShort("?????? ?????? ????????? ???????????????")
                }
            }
        }

        imageUrlVm.run {
            fileList.observe(this@MyProfileFixActivity){
                vm.myProfileFix(MyProfileFixRequest(binding.editChangeName.text.toString(),it.image[0],binding.editChangePhoneNumber.text.toString()))
            }
            fail.observe(this@MyProfileFixActivity){
                when(it){
                    400 -> showToastShort("????????? ?????? ?????????.")
                }
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
                Toast.makeText(this, "?????? ?????? ??????", Toast.LENGTH_LONG).show();
            } else {
                Log.d("ActivityResult", "something wrong")
            }
        }
}