package com.soundapp.feature_home.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.soundapp.feature_home.domain.model.Song
import com.soundapp.feature_home.domain.repository.HomeRepository
import com.soundapp.feature_home.domain.repository.HomeRepositoryOutput

class HomeInteractorImpl(private val homeRepository: HomeRepository) :
    BaseInteractorImpl<HomeInteractorOutput>(), HomeInteractor, HomeRepositoryOutput {

    init {
        homeRepository.setRepositoryOutput(this)
    }

    override fun getInitialSongs() {
        homeRepository.getRockSongs()
    }

    override fun onRockSongsReceived(list: List<Song>) {

    }
}