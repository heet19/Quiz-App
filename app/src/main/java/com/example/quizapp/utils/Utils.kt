package com.example.quizapp.utils

import android.app.Dialog
import android.content.Context
import android.widget.Toast
import com.example.quizapp.R
import kotlin.contracts.contract

object Utils {

    fun showToast(context: Context, msg:String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showProgressBar(context: Context) : Dialog {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.loading_progress_bar)
        dialog.show()
        return dialog
    }

}