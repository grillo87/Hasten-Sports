package com.josegrillo.hastensports.views.ui.splash

import com.josegrillo.hastensports.views.contracts.SplashContract
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashPresenter @Inject constructor(val subscriptions: CompositeDisposable) : SplashContract.Presenter {

    private lateinit var view: SplashContract.View

    override fun unsubscribe() {

        subscriptions.clear()

    }

    override fun attach(view: SplashContract.View) {
        this.view = view
    }


}