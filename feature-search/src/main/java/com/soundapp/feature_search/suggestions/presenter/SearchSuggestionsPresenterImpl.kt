package com.soundapp.feature_search.suggestions.presenter

import com.abecerra.appresources.Translator
import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_search.R
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenterListener
import com.soundapp.feature_search.suggestions.model.SearchSuggestionViewModel
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsAdapter
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsView

class SearchSuggestionsPresenterImpl(
    private val searchPresenterListener: SearchPresenterListener,
    private val translator: Translator
) :
    BasePresenterImpl<SearchSuggestionsView>(), SearchSuggestionsPresenter {

    private val searchSuggestionsAdapter = SearchSuggestionsAdapter {
        searchPresenterListener.onSearchSuggestionSelected(it)
    }

    override fun loadSearchSuggestions() {
        val suggestionsList = createSuggestionsList()
        searchSuggestionsAdapter.setItems(suggestionsList)
    }

    private fun createSuggestionsList(): ArrayList<SearchSuggestionViewModel> {
        return arrayListOf(
            SearchSuggestionViewModel(translator.getString(R.string.jazz), R.color.orange),
            SearchSuggestionViewModel(translator.getString(R.string.rock), R.color.red),
            SearchSuggestionViewModel(translator.getString(R.string.pop), R.color.yellow),
            SearchSuggestionViewModel(translator.getString(R.string.latino), R.color.green)
        )
    }

    override fun getSearchSuggestionsAdapter(): SearchSuggestionsAdapter = searchSuggestionsAdapter
}