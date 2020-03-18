package com.abecerra.soundapp.navigation.routers

import com.abecerra.soundapp.R
import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.scenes.main.router.MainRouter
import com.soundapp.feature_home.presentation.view.HomeFragment
import kotlinx.android.synthetic.main.activity_main.view.*
import javax.inject.Inject

class MainRouterImpl @Inject constructor(
    private val navigator: Navigator,
    private val homeFragment: HomeFragment
) : MainRouter {
    override fun loadDefaultFragment(layout: Int) {
        navigator.replaceFragment(homeFragment, R.id.base_fl)
    }
}