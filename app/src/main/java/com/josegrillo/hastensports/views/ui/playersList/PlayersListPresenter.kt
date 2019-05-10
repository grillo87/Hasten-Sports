package com.josegrillo.hastensports.views.ui.playersList

import com.josegrillo.hastensports.domain.useCases.GetSportsList
import com.josegrillo.hastensports.views.contracts.PlayersListContract
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PlayersListPresenter @Inject constructor(val obtainSportsList: GetSportsList,
                                               val subscriptions: CompositeDisposable) : PlayersListContract.Presenter {

    private lateinit var view: PlayersListContract.View

    override fun unsubscribe() {

        subscriptions.clear()

    }

    override fun attach(view: PlayersListContract.View) {
        this.view = view
    }
}