package com.abecerra.soundapp.di.module.presentation

import android.content.Context
import com.abecerra.appresources.Translator
import com.abecerra.soundapp.AppApplication
import com.soundapp.feature_home.presentation.presenter.HomePresenter
import com.soundapp.feature_home.presentation.view.HomeFragment
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenter
import com.soundapp.feature_search.main.presentation.view.SearchFragment
import com.soundapp.session.login.presenter.LoginPresenter
import com.soundapp.session.login.view.LoginFragment
import dagger.Module
import dagger.Provides

@Module
class ViewModule(private val context: Context) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    fun provideTranslator(): Translator =
        Translator(AppApplication.getInstance())

    @Provides
    fun provideLoginFragment(loginPresenter: LoginPresenter): LoginFragment {
        val loginFragment = LoginFragment()
        loginFragment.injectPresenter(loginPresenter)
        return loginFragment
    }

    @Provides
    fun provideHomeFragment(presenter: HomePresenter): HomeFragment {
        val homeFragment = HomeFragment()
        homeFragment.injectPresenter(presenter)
        return homeFragment
    }

    @Provides
    fun provideSearchFragment(presenter: SearchPresenter): SearchFragment {
        val searchFragment = SearchFragment()
        searchFragment.injectPresenter(presenter)
        return searchFragment
    }
}