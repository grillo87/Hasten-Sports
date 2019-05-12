package com.josegrillo.hastensports.views.ui.splash

import android.os.Bundle
import com.josegrillo.hastensports.R
import com.josegrillo.hastensports.di.components.DaggerActivitiesComponent
import com.josegrillo.hastensports.di.modules.ActivitiesModule
import com.josegrillo.hastensports.di.modules.RemoteRepositoryModule
import com.josegrillo.hastensports.utils.navigateNextActivity
import com.josegrillo.hastensports.views.base.BaseActivity
import com.josegrillo.hastensports.views.contracts.SplashContract
import com.josegrillo.hastensports.views.ui.playersList.PlayersListActivity
import java.util.*
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashContract.Presenter
    val splashTimeDuration: Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_splash)
        super.onCreate(savedInstanceState)

    }


    override fun injectDependencies() {
        val splashComponent = DaggerActivitiesComponent.builder()
            .activitiesModule(ActivitiesModule())
            .remoteRepositoryModule(RemoteRepositoryModule(app))
            .build()

        splashComponent.inject(this)
        presenter.attach(this)
    }


    override fun startSplashTimer() {

        val task = object : TimerTask() {
            override fun run() {

                presenter.handleNextView()

            }
        }

        val timer = Timer()
        timer.schedule(task, splashTimeDuration)

    }

    override fun navigateToSportsList() {

        this.navigateNextActivity(PlayersListActivity::class.java)

    }

}
