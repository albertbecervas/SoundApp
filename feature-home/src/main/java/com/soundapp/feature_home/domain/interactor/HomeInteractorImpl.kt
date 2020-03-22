package com.soundapp.feature_home.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.soundapp.feature_commons.domain.model.Song
import com.soundapp.feature_home.domain.model.HomeSection
import com.soundapp.feature_home.domain.repository.HomeRepository
import com.soundapp.feature_home.domain.repository.HomeRepositoryOutput

class HomeInteractorImpl(private val homeRepository: HomeRepository) :
    BaseInteractorImpl<HomeInteractorOutput>(), HomeInteractor, HomeRepositoryOutput {

    private val sections = arrayListOf<HomeSection>()

    init {
        homeRepository.setRepositoryOutput(this)
    }

    override fun getInitialSongs() {
        homeRepository.getRockSongs()
    }

    override fun onRockSongsReceived(list: List<Song>) {
        sections.add(HomeSection("Rock Top 10", list))
        notifyIfSectionsReady()
    }

    private fun notifyIfSectionsReady() {
        if (sections.size >= 1) output?.onInitialSectionsReady(sections)
    }

}