package com.soundapp.feature_home.domain.interactor

import com.abecerra.appresources.Translator
import com.abecerra.base.domain.BaseInteractorImpl
import com.soundapp.feature_commons.domain.model.SavedSong
import com.soundapp.feature_commons.domain.model.Song
import com.soundapp.feature_home.R
import com.soundapp.feature_home.domain.model.HomeSection
import com.soundapp.feature_home.domain.repository.HomeRepository
import com.soundapp.feature_home.domain.repository.HomeRepositoryOutput

class HomeInteractorImpl(
    private val homeRepository: HomeRepository,
    private val translator: Translator
) : BaseInteractorImpl<HomeInteractorOutput>(), HomeInteractor, HomeRepositoryOutput {

    private val sections = arrayListOf<HomeSection>()

    init {
        homeRepository.setRepositoryOutput(this)
    }

    override fun getRecentSongs() {
        homeRepository.getRecentlyPlayedSongs()
    }

    override fun getInitialSongs() {
        homeRepository.getRockSongs(TOP_SONGS_COUNT)
        homeRepository.getLatinoSongs(TOP_SONGS_COUNT)
        homeRepository.getPopSongs(TOP_SONGS_COUNT)
        homeRepository.getJazzSongs(TOP_SONGS_COUNT)
    }

    override fun onRockSongsReceived(list: List<Song>) {
        sections.add(HomeSection("Rock Top 10", list))
        notifyIfSectionsReady()
    }

    override fun onLatinoSongsReceived(list: List<Song>) {
        sections.add(HomeSection("Latino Top 10", list))
        notifyIfSectionsReady()
    }

    override fun onJazzSongsReceived(list: List<Song>) {
        sections.add(HomeSection("Jazz Top 10", list))
        notifyIfSectionsReady()
    }

    override fun onPopSongsReceived(list: List<Song>) {
        sections.add(HomeSection("Pop Top 10", list))
        notifyIfSectionsReady()
    }

    override fun onRecentlyPlayedSongsFound(list: List<SavedSong>) {
        output?.onRecentPlayedFound(translator.getString(R.string.recently_played), list)
    }

    private fun notifyIfSectionsReady() {
        if (sections.size >= SECTIONS_NUMBER) output?.onInitialSectionsReady(sections)
    }

    companion object {
        const val SECTIONS_NUMBER = 4
        const val TOP_SONGS_COUNT = 10
    }
}