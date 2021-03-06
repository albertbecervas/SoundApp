package com.soundapp.feature_home.presentation.presenter

import com.abecerra.base.presentation.BasePresenter
import com.soundapp.feature_home.presentation.view.HomeView

interface HomePresenter : BasePresenter<HomeView> {

    fun getRecentSongs()

    fun getInitialSongs()

    fun getSectionsAdapter(): HomeSectionAdapter
}