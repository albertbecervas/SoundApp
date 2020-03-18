package com.soundapp.feature_home.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_home.domain.interactor.HomeInteractor
import com.soundapp.feature_home.presentation.router.HomeRouter
import com.soundapp.feature_home.presentation.view.HomeView

class HomePresenterImpl(private val router: HomeRouter, private val interactor: HomeInteractor) :
    BasePresenterImpl<HomeView>(), HomePresenter {
}