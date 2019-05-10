package com.josegrillo.hastensports.views.contracts

class BaseContract {

    interface View {

    }

    interface Presenter<in T> {

        fun unsubscribe()

        fun attach(view: T)
    }
}