package com.soundapp.feature_home.domain.interactor

import com.abecerra.base.domain.BaseInteractor

interface HomeInteractor : BaseInteractor<HomeInteractorOutput> {

    fun getInitialSongs()
}