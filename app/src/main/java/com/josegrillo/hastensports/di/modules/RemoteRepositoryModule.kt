package com.josegrillo.hastensports.di.modules

import android.content.Context
import com.josegrillo.hastensports.BuildConfig
import com.josegrillo.hastensports.base.HastenApplication
import com.josegrillo.hastensports.data.remote.AppApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteRepositoryModule(val app: HastenApplication) {

    @Provides
    @Singleton
    fun provideAppApi(): AppApi = AppApi.create(BuildConfig.BASE_URL)

}