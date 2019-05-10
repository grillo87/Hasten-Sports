package com.josegrillo.hastensports.di.components

import com.josegrillo.hastensports.base.HastenApplication
import com.josegrillo.hastensports.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(app: HastenApplication)


}