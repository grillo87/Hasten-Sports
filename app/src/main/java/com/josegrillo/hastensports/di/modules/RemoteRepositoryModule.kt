package com.josegrillo.hastensports.di.modules

import android.content.Context
import com.josegrillo.hastensports.base.HastenApplication
import com.josegrillo.hastensports.data.remote.AppApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteRepositoryModule(val app: HastenApplication) {

    @Provides
    @Singleton
    fun provideContext() = app.applicationContext

    @Provides
    @Singleton
    fun provideAppApi(context: Context): AppApi = AppApi.create(context)

}