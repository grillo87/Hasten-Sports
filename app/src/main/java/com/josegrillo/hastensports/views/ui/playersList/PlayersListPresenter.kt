package com.josegrillo.hastensports.views.ui.playersList

import com.josegrillo.hastensports.domain.models.mappers.sportModelToSportView
import com.josegrillo.hastensports.domain.useCases.GetSportsList
import com.josegrillo.hastensports.views.contracts.PlayersListContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PlayersListPresenter @Inject constructor(val obtainSportsList: GetSportsList,
                                               val subscriptions: CompositeDisposable) : PlayersListContract.Presenter {

    private lateinit var view: PlayersListContract.View

    override fun unsubscribe() {

        subscriptions.clear()

    }

    override fun attach(view: PlayersListContract.View) {
        this.view = view
        this.view.configureViewListeners()
        this.getSportsList()
    }


    override fun getSportsList() {

        this.view.showLoading()

        var subscribe = obtainSportsList.getSportsList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { sportsModelList ->
                ArrayList(sportsModelList.map { it.sportModelToSportView() })
            }
            .subscribe(
                { sportArrayList ->

                    if (sportArrayList.isNotEmpty())
                        this.view.displayPlayersList(sportArrayList)
                    else
                        this.view.displayError(null)

                    this.view.hideLoading()

                },
                { error ->
                    this.view.displayError(error)
                    this.view.hideLoading()
                })

        subscriptions.add(subscribe)

    }

}