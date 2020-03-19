package com.soundapp.feature_search.main.domain.interactor

import com.abecerra.base.domain.BaseInteractor
import com.soundapp.feature_search.main.domain.interactor.SearchInteractorOutput

interface SearchInteractor : BaseInteractor<SearchInteractorOutput> {

    fun getInitialSongs()
}