package com.abecerra.soundapp.scenes.main.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.abecerra.components.bottomnavigation.viewModel.NavigationItem
import com.abecerra.soundapp.R
import com.abecerra.soundapp.scenes.main.router.MainRouter
import com.abecerra.soundapp.scenes.main.view.MainView

class MainPresenterImpl(private val router: MainRouter) :
    BasePresenterImpl<MainView>(), MainPresenter {

    override fun loadHomeFragment() {
        router.loadDefaultFragment(R.id.base_fl)
    }

    override fun getNavigationItems(): List<NavigationItem> {
        val items = arrayListOf<NavigationItem>()
        items.add(NavigationItem("home", R.mipmap.ic_launcher_round))
        items.add(NavigationItem("diet", R.mipmap.ic_launcher_round))
        items.add(NavigationItem("diet", R.mipmap.ic_launcher_round))
        items.add(NavigationItem("diet", R.mipmap.ic_launcher_round))
        items.add(NavigationItem("profile", R.mipmap.ic_launcher_round))
        return items
    }
}