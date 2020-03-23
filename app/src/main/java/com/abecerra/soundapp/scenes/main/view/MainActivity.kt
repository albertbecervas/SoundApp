package com.abecerra.soundapp.scenes.main.view

import android.os.Bundle
import com.abecerra.base.presentation.BaseActivity
import com.abecerra.soundapp.R
import com.abecerra.soundapp.di.component.DaggerViewComponent
import com.abecerra.soundapp.di.module.presentation.ViewModule
import com.abecerra.soundapp.scenes.main.presenter.MainPresenter
import com.soundapp.session.authentication.domain.interactor.SessionInteractor
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var sessionInteractor: SessionInteractor

    override fun getLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerViewComponent.builder().viewModule(ViewModule(this))
            .build().inject(this)

        presenter.setView(this)
        presenter.setBottomNavigationComponent(bottom_navigation)
    }
}
