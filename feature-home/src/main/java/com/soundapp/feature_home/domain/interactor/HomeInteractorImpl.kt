package com.soundapp.feature_home.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.soundapp.feature_home.domain.repository.HomeRepository

class HomeInteractorImpl(private val homeRepository: HomeRepository) :
    BaseInteractorImpl<HomeInteractorOutput>(), HomeInteractor {
}