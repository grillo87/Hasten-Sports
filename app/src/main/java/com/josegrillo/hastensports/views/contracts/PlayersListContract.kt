package com.josegrillo.hastensports.views.contracts

import com.josegrillo.hastensports.views.models.Sport
import java.lang.Exception

class PlayersListContract {

    interface View : BaseContract.View {

        fun displayPlayersList(sportList: ArrayList<Sport>)
        fun showLoading()
        fun hideLoading()
        fun displayError(error: Throwable?)


    }

    interface Presenter : BaseContract.Presenter<View> {

        fun getSportsList()

    }


}