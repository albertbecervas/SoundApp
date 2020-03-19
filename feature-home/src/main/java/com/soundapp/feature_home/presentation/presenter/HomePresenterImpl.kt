package com.soundapp.feature_home.presentation.presenter

import android.util.Log
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

    private val adapter: HomeSongAdapter = HomeSongAdapter()

    init {
        interactor.setInteractorOutput(this)
    }

    override fun getInitialSongs() {
        interactor.getInitialSongs()
        getView()?.showLoading()
    }

    override fun getRockAdapter(): HomeSongAdapter = adapter

    override fun onDefaultSongsReceived(list: List<Song>) {
        val songs: List<SongViewModel> = SongViewModelMapper.mapSongs(list)
        adapter.setItems(songs)
        getView()?.hideLoading()
    }
}