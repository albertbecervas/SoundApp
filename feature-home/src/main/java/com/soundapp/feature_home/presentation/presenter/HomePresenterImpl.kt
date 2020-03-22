package com.soundapp.feature_home.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_home.domain.interactor.HomeInteractor
import com.soundapp.feature_home.domain.interactor.HomeInteractorOutput
import com.soundapp.feature_home.domain.model.HomeSection
import com.soundapp.feature_home.presentation.model.SectionViewModelMapper
import com.soundapp.feature_home.presentation.router.HomeRouter
import com.soundapp.feature_home.presentation.view.HomeView

class HomePresenterImpl(private val router: HomeRouter, private val interactor: HomeInteractor) :
    BasePresenterImpl<HomeView>(), HomePresenter, HomeInteractorOutput {

    private val sectionsAdapter: HomeSectionAdapter = HomeSectionAdapter()

    init {
        interactor.setInteractorOutput(this)
    }

    override fun getInitialSongs() {
        interactor.getInitialSongs()
    }

    override fun getSectionsAdapter(): HomeSectionAdapter = sectionsAdapter

    override fun onInitialSectionsReady(list: List<HomeSection>) {
        sectionsAdapter.setItems(SectionViewModelMapper.map(list))
    }
}