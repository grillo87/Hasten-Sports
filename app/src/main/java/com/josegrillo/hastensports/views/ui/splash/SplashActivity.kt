package com.josegrillo.hastensports.views.ui.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.josegrillo.hastensports.R
import com.josegrillo.hastensports.di.components.DaggerActivitiesComponent
import com.josegrillo.hastensports.di.modules.ActivitiesModule
import com.josegrillo.hastensports.di.modules.RemoteRepositoryModule
import com.josegrillo.hastensports.views.base.BaseActivity
import com.josegrillo.hastensports.views.contracts.SplashContract
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashContract.Presenter

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
}
