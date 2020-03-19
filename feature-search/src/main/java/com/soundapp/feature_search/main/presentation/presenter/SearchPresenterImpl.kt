package com.soundapp.feature_search.main.presentation.presenter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.abecerra.base.presentation.BasePresenterImpl
import com.abecerra.components.search.SearchComponentOutput
import com.soundapp.feature_search.main.domain.interactor.SearchInteractorOutput
import com.soundapp.feature_search.main.domain.model.Song
import com.soundapp.feature_search.main.presentation.model.SongViewModel
import com.soundapp.feature_search.main.presentation.model.SongViewModelMapper
import com.soundapp.feature_search.main.presentation.router.SearchRouter
import com.soundapp.feature_search.main.presentation.view.SearchView
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor

class SearchPresenterImpl(
    private val router: SearchRouter,
    private val interactor: SearchInteractor
) : BasePresenterImpl<SearchView>(), SearchPresenter, SearchInteractorOutput,
    SearchComponentOutput {

    init {
        interactor.setInteractorOutput(this)
    }

    override fun loadInitialSearchFragment() {
        getChildFragmentManager()?.let {
            router.loadSearchSuggestionsFragment(it)
        }
    }

    override fun onDefaultSongsReceived(list: List<Song>) {
        val songs: List<SongViewModel> = SongViewModelMapper.mapSongs(list)
        getView()?.hideLoading()
    }

    override fun onSearch(text: String) {

    }

    override fun emptySearch() {
        getChildFragmentManager()?.let {
            router.loadSearchSuggestionsFragment(it)
        }
    }

    private fun getChildFragmentManager(): FragmentManager? {
        return (getView() as? Fragment)?.childFragmentManager
    }
}