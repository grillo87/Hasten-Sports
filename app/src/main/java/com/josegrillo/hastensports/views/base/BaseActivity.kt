package com.josegrillo.hastensports.views.base

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.josegrillo.hastensports.base.HastenApplication

open class BaseActivity : AppCompatActivity() {

    var dialog: Dialog? = null
    val Activity.app: HastenApplication
        get() = application as HastenApplication



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        setStatusBar()
        initializeSupportActionBar()

    }


    private fun setStatusBar() {

        //PantallaUtils.colorearStatusBar(this)

    }

    open fun injectDependencies() {}

    open fun initializeSupportActionBar() {}

    open fun displayErrorMessage(error: Throwable?) {

        /*
        var mensajeAMostrar = this.resources.getString(R.string.error_inesperado_titulo)
        error?.let {

            mensajeAMostrar = ErrorUtils.manejadorDeErrores(it, applicationContext)

        }

        ToastUtils.showToastMessage(applicationContext, mensajeAMostrar)
        */

    }

    //open fun obtenerApp(): HastenApplication = this.app


}