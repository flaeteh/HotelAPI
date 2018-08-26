package com.root.hotelapi

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.indeterminateProgressDialog

abstract class BaseActivity : AppCompatActivity(){
    lateinit var progressDialog : ProgressDialog

    //SHOW PROGRESS DIALOG
    fun showProgressDialog() {
        progressDialog = indeterminateProgressDialog("Loading...")
        progressDialog.show()
    }

    //DISMISS PROGRESS DIALOG
    fun dismissProgressDialog() {
        progressDialog.dismiss()
    }


}