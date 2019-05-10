package com.josegrillo.hastensports.di.modules

import com.josegrillo.hastensports.domain.useCases.GetSportsList
import com.josegrillo.hastensports.views.contracts.PlayersListContract
import com.josegrillo.hastensports.views.contracts.SplashContract
import com.josegrillo.hastensports.views.ui.playersList.PlayersListPresenter
import com.josegrillo.hastensports.views.ui.splash.SplashPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivitiesModule {

    @Provides
    fun provideSubscription(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSplashPresenter(subscriptions: CompositeDisposable): SplashContract.Presenter {
        return SplashPresenter(subscriptions)
    }

    @Provides
    fun providePlayersList(obtainSportsList: GetSportsList, subscriptions: CompositeDisposable): PlayersListContract.Presenter {
        return PlayersListPresenter(obtainSportsList, subscriptions)
    }

}