package com.soundapp.feature_search.main.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.soundapp.feature_search.main.domain.model.SearchSong
import com.soundapp.feature_search.main.domain.repository.SearchRepository
import com.soundapp.feature_search.main.domain.repository.SearchRepositoryOutput

class SearchInteractorImpl(private val searchRepository: SearchRepository) :
    BaseInteractorImpl<SearchInteractorOutput>(), SearchInteractor, SearchRepositoryOutput {

    init {
        searchRepository.setRepositoryOutput(this)
    }

    override fun searchSongs(term: String) {
        searchRepository.doSearchCallWithTerm(term)
    }

    override fun onSearchResponse(list: List<SearchSong>) {
        output?.onSearchSongsReceived(list)
    }
}