package com.abecerra.soundapp.scenes.main.presenter

import com.abecerra.base.presentation.BasePresenter
import com.abecerra.components.bottomnavigation.BottomNavigationComponent
import com.abecerra.soundapp.scenes.main.view.MainView

interface MainPresenter : BasePresenter<MainView> {

    fun setBottomNavigationComponent(bottomNavigationComponent: BottomNavigationComponent)

    fun onBackStackChanged(fragmentName: String?)
}