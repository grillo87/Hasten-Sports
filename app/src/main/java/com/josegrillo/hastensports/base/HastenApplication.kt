package com.josegrillo.hastensports.base

import android.app.Application
import com.josegrillo.hastensports.di.components.AppComponent
import com.josegrillo.hastensports.di.components.DaggerAppComponent
import com.josegrillo.hastensports.di.modules.AppModule

class HastenApplication : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

}