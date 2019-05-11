package com.josegrillo.hastensports.views.ui.playersList

import android.os.Bundle
import android.util.Log
import com.josegrillo.hastensports.R
import com.josegrillo.hastensports.di.components.DaggerActivitiesComponent
import com.josegrillo.hastensports.di.modules.ActivitiesModule
import com.josegrillo.hastensports.di.modules.RemoteRepositoryModule
import com.josegrillo.hastensports.views.base.BaseActivity
import com.josegrillo.hastensports.views.contracts.PlayersListContract
import com.josegrillo.hastensports.views.models.Sport
import javax.inject.Inject

class PlayersListActivity : BaseActivity(), PlayersListContract.View {

    @Inject
    lateinit var presenter: PlayersListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_players_list)
        super.onCreate(savedInstanceState)
    }

    override fun injectDependencies() {
        val playersListComponent = DaggerActivitiesComponent.builder()
            .activitiesModule(ActivitiesModule())
            .remoteRepositoryModule(RemoteRepositoryModule(app))
            .build()

        playersListComponent.inject(this)
        presenter.attach(this)
    }

    override fun displayPlayersList(sportList: ArrayList<Sport>) {


    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun displayError(error: Throwable?) {
        
    }

}
