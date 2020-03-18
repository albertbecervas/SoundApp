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

    init {
        interactor.setInteractorOutput(this)
    }

    override fun getInitialSongs() {
        interactor.getInitialSongs()
    }

    override fun onDefaultSongsReceived(list: List<Song>) {
        val songs: List<SongViewModel> = SongViewModelMapper.mapSongs(list)
    }
}