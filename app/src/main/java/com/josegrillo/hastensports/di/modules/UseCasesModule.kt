package com.josegrillo.hastensports.di.modules

import com.josegrillo.hastensports.data.remote.AppApi
import com.josegrillo.hastensports.domain.useCases.GetSportsList
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun provideGetSportsList(appApi: AppApi): GetSportsList = GetSportsList(appApi)

}