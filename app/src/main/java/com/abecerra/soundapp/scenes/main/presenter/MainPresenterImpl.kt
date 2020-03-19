package com.abecerra.soundapp.scenes.main.presenter

import com.abecerra.appresources.Translator
import com.abecerra.base.presentation.BasePresenterImpl
import com.abecerra.components.bottomnavigation.BottomNavigationComponent
import com.abecerra.components.bottomnavigation.BottomNavigationListener
import com.abecerra.components.bottomnavigation.viewModel.NavigationItem
import com.abecerra.soundapp.R
import com.abecerra.soundapp.scenes.main.router.MainRouter
import com.abecerra.soundapp.scenes.main.view.MainView
import com.soundapp.feature_home.presentation.view.HomeFragment
import com.soundapp.feature_search.main.presentation.view.SearchFragment

class MainPresenterImpl(private val router: MainRouter, private val translator: Translator) :
    BasePresenterImpl<MainView>(), MainPresenter {

    private var bottomNavigationComponent: BottomNavigationComponent? = null

    override fun setBottomNavigationComponent(bottomNavigationComponent: BottomNavigationComponent) {
        this.bottomNavigationComponent = bottomNavigationComponent
        this.bottomNavigationComponent
            ?.setBottomNavigationListener(object : BottomNavigationListener {
                override fun onItemSelected(position: Int) {
                    when (position) {
                        HOME_POSITION -> router.loadHomeFragment()
                        SEARCH_POSITION -> router.loadSearchFragment()
                    }
                }
            })
        this.bottomNavigationComponent?.setItems(getNavigationItems())
    }

    override fun onBackStackChanged(fragmentName: String?) {
        when (fragmentName) {
            HomeFragment::class.java.name -> bottomNavigationComponent?.setItemSelected(
                HOME_POSITION
            )
            SearchFragment::class.java.name -> bottomNavigationComponent?.setItemSelected(
                SEARCH_POSITION
            )
        }
    }

    private fun getNavigationItems(): List<NavigationItem> {
        val items = arrayListOf<NavigationItem>()
        items.add(NavigationItem(translator.getString(R.string.home_title), R.drawable.ic_home))
        items.add(NavigationItem(translator.getString(R.string.search_title), R.drawable.ic_search))
        items.add(NavigationItem(translator.getString(R.string.profile_title), R.drawable.ic_user))
        return items
    }

    companion object {
        const val HOME_POSITION = 0
        const val SEARCH_POSITION = 1
    }
}