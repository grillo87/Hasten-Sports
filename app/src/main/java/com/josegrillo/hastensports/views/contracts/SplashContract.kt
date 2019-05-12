package com.josegrillo.hastensports.views.contracts

class SplashContract {

    interface View : BaseContract.View {

        fun startSplashTimer()
        fun navigateToSportsList()

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun handleNextView()

    }

}