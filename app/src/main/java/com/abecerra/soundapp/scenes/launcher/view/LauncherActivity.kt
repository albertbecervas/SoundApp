package com.abecerra.soundapp.scenes.launcher.view

import android.os.Bundle
import com.abecerra.base.presentation.BaseActivity
import com.abecerra.soundapp.R
import com.abecerra.soundapp.di.component.DaggerViewComponent
import com.abecerra.soundapp.di.module.presentation.ViewModule
import com.abecerra.soundapp.scenes.launcher.presenter.LauncherPresenter
import javax.inject.Inject

class LauncherActivity : BaseActivity(), LauncherView {

    @Inject
    lateinit var presenter: LauncherPresenter

    override fun getLayout(): Int = R.layout.activity_launcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerViewComponent.builder().viewModule(ViewModule(this))
            .build().inject(this)
        presenter.setView(this)
        presenter.decideNavigation()
    }
}
