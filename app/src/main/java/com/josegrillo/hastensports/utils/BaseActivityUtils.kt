package com.josegrillo.hastensports.utils

import android.content.Intent
import com.josegrillo.hastensports.views.base.BaseActivity

fun BaseActivity.navigateNextActivity(destionationActivity: Class<*>) {

    val navigationIntent = Intent().setClass(this, destionationActivity)
    this.startActivity(navigationIntent)
    this.finish()

}