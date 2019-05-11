package com.josegrillo.hastensports.views.ui.playersList

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.josegrillo.hastensports.R
import com.josegrillo.hastensports.di.components.DaggerActivitiesComponent
import com.josegrillo.hastensports.di.modules.ActivitiesModule
import com.josegrillo.hastensports.di.modules.RemoteRepositoryModule
import com.josegrillo.hastensports.views.base.BaseActivity
import com.josegrillo.hastensports.views.contracts.PlayersListContract
import com.josegrillo.hastensports.views.models.Sport
import com.josegrillo.hastensports.views.ui.adapters.SportsAdapter
import kotlinx.android.synthetic.main.activity_players_list.*
import javax.inject.Inject

class PlayersListActivity : BaseActivity(), PlayersListContract.View, SwipeRefreshLayout.OnRefreshListener {

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

    override fun onDestroy() {
        presenter.unsubscribe()
        super.onDestroy()
    }

    override fun configureViewListeners() {
        swipeRefreshLayout.setOnRefreshListener(this)
    }

    override fun displayPlayersList(sportList: ArrayList<Sport>) {

        sportsRecyclerView.adapter = SportsAdapter(sportList)
        sportsRecyclerView.layoutManager = LinearLayoutManager(this.applicationContext)


    }

    override fun showLoading() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun displayError(error: Throwable?) {

        super.displayErrorMessage(error)

    }

    override fun onRefresh() {
        this.presenter.getSportsList()
    }

}
