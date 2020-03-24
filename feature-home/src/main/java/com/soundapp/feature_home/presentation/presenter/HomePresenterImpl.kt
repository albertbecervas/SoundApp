package com.soundapp.feature_home.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_commons.domain.PlaylistInteractor
import com.soundapp.feature_commons.domain.model.SavedSong
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_home.domain.interactor.HomeInteractor
import com.soundapp.feature_home.domain.interactor.HomeInteractorOutput
import com.soundapp.feature_home.domain.model.HomeSection
import com.soundapp.feature_home.presentation.model.SectionViewModelMapper
import com.soundapp.feature_home.presentation.router.HomeRouter
import com.soundapp.feature_home.presentation.view.HomeView

class HomePresenterImpl(
    private val router: HomeRouter, private val interactor: HomeInteractor,
    private val playListInteractor: PlaylistInteractor
) : BasePresenterImpl<HomeView>(), HomePresenter, HomeInteractorOutput {

    private val sectionsAdapter: HomeSectionAdapter = HomeSectionAdapter { item, list ->
        handleItemClicked(item, list)
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

    override fun onRecentPlayedFound(sectionName: String, list: List<SavedSong>) {
        sectionsAdapter.getItems().find { it.sectionName == sectionName }?.let {
            sectionsAdapter.replaceItem(it, SectionViewModelMapper.map(sectionName, list))
        } ?: sectionsAdapter.addItem(SectionViewModelMapper.map(sectionName, list))
    }

    override fun onInitialSectionsReady(list: List<HomeSection>) {
        sectionsAdapter.addItems(SectionViewModelMapper.map(list))
        getView()?.hideLoading()
    }

    private fun handleItemClicked(item: SongViewModel, list: ArrayList<SongViewModel>) {
        val songsList =
            playListInteractor.preparePlayListFromItemSelected(item, list).toTypedArray()
        router.onSongSelected(songsList)
    }
}
