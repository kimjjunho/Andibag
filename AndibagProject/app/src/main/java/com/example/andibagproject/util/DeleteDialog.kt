package com.example.andibagproject.feature

import android.app.Dialog
import android.content.Context
import android.widget.Button
import android.widget.TextView
import com.example.andibagproject.R

fun settingDialogDelete(context: Context, text: String, function:()->Unit){
    val dialog = Dialog(context)
    dialog.setContentView(R.layout.dialog_delete)
    dialog.setCancelable(false)
    dialog.show()

    val dialogBtnCancel : Button = dialog.findViewById(R.id.dialog_btn_cacel)
    val dialogBtnCheck : Button = dialog.findViewById(R.id.dialog_btn_check)
    val dialogTvQuestion : TextView = dialog.findViewById(R.id.tv_question)

    dialogTvQuestion.text = text
    dialogBtnCancel.setOnClickListener {
        dialog.dismiss()
    }

    dialogBtnCheck.setOnClickListener {
        dialog.dismiss()
        function()
    }
}