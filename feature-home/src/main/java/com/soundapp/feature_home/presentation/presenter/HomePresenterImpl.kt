package com.soundapp.feature_home.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_home.domain.interactor.HomeInteractor
import com.soundapp.feature_home.domain.interactor.HomeInteractorOutput
import com.soundapp.feature_home.domain.model.Song
import com.soundapp.feature_home.presentation.model.SongViewModel
import com.soundapp.feature_home.presentation.model.SongViewModelMapper
import com.soundapp.feature_home.presentation.router.HomeRouter
import com.soundapp.feature_home.presentation.view.HomeView

class HomePresenterImpl(private val router: HomeRouter, private val interactor: HomeInteractor) :
    BasePresenterImpl<HomeView>(), HomePresenter, HomeInteractorOutput {

    private val rockAdapter: HomeSongAdapter = HomeSongAdapter()
    private val jazzAdapter: HomeSongAdapter = HomeSongAdapter()
    private val popAdapter: HomeSongAdapter = HomeSongAdapter()

    init {
        interactor.setInteractorOutput(this)
    }

    override fun getInitialSongs() {
        interactor.getInitialSongs()
        getView()?.showLoading()
    }

    override fun getRockAdapter(): HomeSongAdapter = rockAdapter
    override fun getJazzAdapter(): HomeSongAdapter = jazzAdapter
    override fun getPopAdapter(): HomeSongAdapter = popAdapter

    override fun onDefaultSongsReceived(list: List<Song>) {
        val songs: List<SongViewModel> = SongViewModelMapper.mapSongs(list)
        rockAdapter.setItems(songs)
        jazzAdapter.setItems(songs)
        popAdapter.setItems(songs)
        getView()?.hideLoading()
    }
}