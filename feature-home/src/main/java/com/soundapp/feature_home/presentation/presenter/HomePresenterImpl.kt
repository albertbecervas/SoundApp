package com.soundapp.feature_home.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_commons.domain.PlaylistInteractor
import com.soundapp.feature_home.domain.interactor.HomeInteractor
import com.soundapp.feature_home.domain.interactor.HomeInteractorOutput
import com.soundapp.feature_home.domain.model.HomeSection
import com.soundapp.feature_home.presentation.model.SectionViewModelMapper
import com.soundapp.feature_home.presentation.router.HomeRouter
import com.soundapp.feature_home.presentation.view.HomeView

class HomePresenterImpl(
    private val router: HomeRouter, private val interactor: HomeInteractor,
    private val playListInteractor: PlaylistInteractor
) :
    BasePresenterImpl<HomeView>(), HomePresenter, HomeInteractorOutput {

    private val sectionsAdapter: HomeSectionAdapter = HomeSectionAdapter { item, list ->
        val songsList = playListInteractor.preparePlayListFromItemSelected(item, list)
        router.onSongSelected(songsList.toTypedArray())
    }

    init {
        interactor.setInteractorOutput(this)
    }

    override fun getInitialSongs() {
        interactor.getInitialSongs()
        getView()?.showLoading()
    }

    override fun getSectionsAdapter(): HomeSectionAdapter = sectionsAdapter

    override fun onRecentPlayedFound(section: HomeSection) {
        sectionsAdapter.addItem(SectionViewModelMapper.map(section))
    }

    override fun onInitialSectionsReady(list: List<HomeSection>) {
        sectionsAdapter.addItems(SectionViewModelMapper.map(list))
        getView()?.hideLoading()
    }
}