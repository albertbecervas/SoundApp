package com.abecerra.soundapp.navigation.routers

import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.scenes.main.router.MainRouter
import com.soundapp.feature_home.presentation.view.HomeFragment
import com.soundapp.feature_search.main.presentation.view.SearchFragment

class MainRouterImpl(
    private val navigator: Navigator,
    private val homeFragment: HomeFragment,
    private val searchFragment: SearchFragment
) : MainRouter {

    override fun loadHomeFragment(layout: Int) {
        navigator.replaceFragment(homeFragment, layout)
    }

    override fun loadSearchFragment(layout: Int) {
        navigator.replaceFragment(searchFragment, layout)
    }
}