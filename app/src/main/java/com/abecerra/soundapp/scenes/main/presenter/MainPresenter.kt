package com.abecerra.soundapp.scenes.main.presenter

import com.abecerra.base.presentation.BasePresenter
import com.abecerra.components.bottomnavigation.viewModel.NavigationItem
import com.abecerra.soundapp.scenes.main.view.MainView

interface MainPresenter : BasePresenter<MainView> {

    fun loadHomeFragment()

    fun getNavigationItems(): List<NavigationItem>
}