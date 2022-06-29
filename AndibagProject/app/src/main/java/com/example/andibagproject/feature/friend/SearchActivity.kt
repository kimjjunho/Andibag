package com.example.andibagproject.feature.friend

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.size
import com.example.andibagproject.R
import com.example.andibagproject.databinding.ActivitySearchBinding
import com.example.andibagproject.feature.base.BaseActivity
import com.example.andibagproject.feature.friend.add.ui.AddFriendActivity

class SearchActivity : BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            visibilitySetting()

            imageBack.setOnClickListener {
                finish()
            }

            btnAddFriendPage.setOnClickListener {
                startActivity(Intent(applicationContext,AddFriendActivity::class.java))
                finish()
            }

            btnDelete.setOnClickListener {
                settingDialog()
            }
        }
    }

    private fun settingDialog(){
        val dialog = Dialog(this@SearchActivity)
        dialog.setContentView(R.layout.dialog_search_friend_all_delete)
        dialog.setCancelable(false)
        dialog.show()

        val dialogBtnCancel : Button = dialog.findViewById(R.id.dialog_btn_cacel)
        val dialogBtnCheck : Button = dialog.findViewById(R.id.dialog_btn_check)

        dialogBtnCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialogBtnCheck.setOnClickListener {
            Toast.makeText(applicationContext,"모두 삭제되었습니다",Toast.LENGTH_SHORT).show()
        }
    }

    private fun visibilitySetting(){
        binding.run {
            if(rv.size != 0){
                layoutFindFriend.visibility = View.INVISIBLE
                btnDelete.visibility = View.VISIBLE
            }
        }
    }

    override fun observeEvent() {}
}