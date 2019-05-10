package com.josegrillo.hastensports.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivitiesModule {

    @Provides
    fun provideSubscription(): CompositeDisposable = CompositeDisposable()

    /*
    @Provides
    fun provideSplashPresenter(subscriptions: CompositeDisposable): SplashContract.Presenter {
        return SplashPresenter(subscriptions)
    }

    @Provides
    fun providePlayersList(obtainSportsList: GetSportsList, subscriptions: CompositeDisposable): PlayersListContract.Presenter {
        return PlayersListPresenter(obtainSportsList, subscriptions)
    }
    */

}