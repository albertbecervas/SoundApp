package com.abecerra.soundapp.scenes.main.presenter

import com.abecerra.appresources.Translator
import com.abecerra.base.presentation.BasePresenterImpl
import com.abecerra.components.bottomnavigation.viewModel.NavigationItem
import com.abecerra.soundapp.R
import com.abecerra.soundapp.scenes.main.router.MainRouter
import com.abecerra.soundapp.scenes.main.view.MainView

class MainPresenterImpl(private val router: MainRouter, private val translator: Translator) :
    BasePresenterImpl<MainView>(), MainPresenter {

    override fun loadHomeFragment() {
        router.loadDefaultFragment(R.id.base_fl)
    }

    override fun getNavigationItems(): List<NavigationItem> {
        val items = arrayListOf<NavigationItem>()
        items.add(NavigationItem(translator.getString(R.string.home_title), R.drawable.ic_home))
        items.add(NavigationItem(translator.getString(R.string.search_title), R.drawable.ic_search))
        items.add(NavigationItem(translator.getString(R.string.profile_title), R.drawable.ic_user))
        return items
    }
}