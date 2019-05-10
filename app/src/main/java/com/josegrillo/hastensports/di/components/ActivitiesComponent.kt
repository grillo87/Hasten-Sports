package com.josegrillo.hastensports.di.components

import com.josegrillo.hastensports.di.modules.ActivitiesModule
import com.josegrillo.hastensports.di.modules.RemoteRepositoryModule
import com.josegrillo.hastensports.di.modules.UseCasesModule
import com.josegrillo.hastensports.views.ui.playersList.PlayersListActivity
import com.josegrillo.hastensports.views.ui.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ActivitiesModule::class, UseCasesModule::class, RemoteRepositoryModule::class))
interface ActivitiesComponent {

    fun inject(splashActivity: SplashActivity)

    fun inject(playersListActivity: PlayersListActivity)


}