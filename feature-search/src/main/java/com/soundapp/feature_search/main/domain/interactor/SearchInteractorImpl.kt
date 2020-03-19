package com.soundapp.feature_search.main.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.soundapp.feature_search.main.domain.model.Song
import com.soundapp.feature_search.main.domain.repository.SearchRepository
import com.soundapp.feature_search.main.domain.repository.SearchRepositoryOutput
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor

class SearchInteractorImpl(private val searchRepository: SearchRepository) :
    BaseInteractorImpl<SearchInteractorOutput>(),
    SearchInteractor,
    SearchRepositoryOutput {

    init {
        searchRepository.setRepositoryOutput(this)
    }

    override fun getInitialSongs() {
        searchRepository.getRockSongs()
    }

    override fun onRockSongsReceived(list: List<Song>) {
        output?.onDefaultSongsReceived(list)
    }
}