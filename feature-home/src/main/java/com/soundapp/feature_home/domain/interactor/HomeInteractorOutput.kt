package com.soundapp.feature_home.domain.interactor

import com.soundapp.feature_home.domain.model.HomeSection

interface HomeInteractorOutput {

    fun onInitialSectionsReady(list: List<HomeSection>)
}