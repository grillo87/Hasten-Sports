package com.josegrillo.hastensports.views.ui.playersList

import com.josegrillo.hastensports.domain.useCases.GetSportsList
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PlayersListPresenter @Inject constructor(val obtainSportsList: GetSportsList,
                                               val subscriptions: CompositeDisposable) {
}