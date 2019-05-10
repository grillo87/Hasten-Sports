package com.josegrillo.hastensports.di.modules

import com.josegrillo.hastensports.base.HastenApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: HastenApplication) {

    @Provides
    @Singleton
    fun provideApp() = app


}