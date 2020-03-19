package com.soundapp.feature_search.suggestions

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor
import com.soundapp.feature_search.main.domain.interactor.SearchInteractorOutput
import com.soundapp.feature_search.main.domain.model.Song

class SearchSuggestionsPresenterImpl(private val interactor: SearchInteractor) :
    BasePresenterImpl<SearchSuggestionsView>(), SearchSuggestionsPresenter, SearchInteractorOutput {

    init {
        interactor.setInteractorOutput(this)
    }

    override fun onDefaultSongsReceived(list: List<Song>) {

    }
}