package com.soundapp.feature_home.presentation.presenter

import com.abecerra.appresources.Translator
import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_commons.domain.PlaylistInteractor
import com.soundapp.feature_commons.domain.model.SavedSong
import com.soundapp.feature_commons.presentation.SongViewModelMapper
import com.soundapp.feature_home.R
import com.soundapp.feature_home.domain.interactor.HomeInteractor
import com.soundapp.feature_home.domain.interactor.HomeInteractorOutput
import com.soundapp.feature_home.domain.model.HomeSection
import com.soundapp.feature_home.presentation.model.SectionViewModel
import com.soundapp.feature_home.presentation.model.SectionViewModelMapper
import com.soundapp.feature_home.presentation.router.HomeRouter
import com.soundapp.feature_home.presentation.view.HomeFragment
import com.soundapp.feature_home.presentation.view.HomeView

class HomePresenterImpl(
    private val router: HomeRouter, private val interactor: HomeInteractor,
    private val playListInteractor: PlaylistInteractor, private val translator: Translator
) : BasePresenterImpl<HomeView>(), HomePresenter, HomeInteractorOutput {

    private val sectionsAdapter: HomeSectionAdapter = HomeSectionAdapter { item, list ->
        val songsList = playListInteractor.preparePlayListFromItemSelected(item, list)
        router.onSongSelected(songsList.toTypedArray())
    }

    init {
        interactor.setInteractorOutput(this)
    }

    override fun getRecentSongs() {
        interactor.getRecentSongs()
    }

    override fun getInitialSongs() {
        interactor.getInitialSongs()
        getView()?.showLoading()
    }

    override fun getSectionsAdapter(): HomeSectionAdapter = sectionsAdapter

    override fun onRecentPlayedFound(list: List<SavedSong>) {
        val sectionViewModel = SectionViewModel(
            translator.getString(R.string.recently_played),
            SongViewModelMapper.mapSavedSongs(list)
        )
        sectionsAdapter.addItem(sectionViewModel)
    }

    override fun onInitialSectionsReady(list: List<HomeSection>) {
        sectionsAdapter.addItems(SectionViewModelMapper.map(list))
        getView()?.hideLoading()
    }
}