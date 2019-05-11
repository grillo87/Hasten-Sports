package com.josegrillo.hastensports.views.base

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.josegrillo.hastensports.R
import com.josegrillo.hastensports.base.HastenApplication
import com.josegrillo.hastensports.utils.showToastMessage

open class BaseActivity : AppCompatActivity() {

    var dialog: Dialog? = null
    val Activity.app: HastenApplication
        get() = application as HastenApplication



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()

    }


    open fun injectDependencies() {}

    open fun displayErrorMessage(error: Throwable?) {

        var errorMessage = this.resources.getString(R.string.unexpected_error_message)
        error?.let {

            errorMessage = error.message

        }

        this.showToastMessage(errorMessage)


    }


}