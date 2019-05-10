package com.josegrillo.hastensports.views.ui.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.josegrillo.hastensports.R
import com.josegrillo.hastensports.views.contracts.SplashContract

class SplashActivity : AppCompatActivity(), SplashContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}
