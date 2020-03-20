package com.soundapp.feature_search.suggestions.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_search.R
import com.soundapp.feature_search.main.SearchPresenterListener
import com.soundapp.feature_search.suggestions.model.SearchSuggestionViewModel
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsAdapter
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsView

class SearchSuggestionsPresenterImpl(private val searchPresenterListener: SearchPresenterListener) :
    BasePresenterImpl<SearchSuggestionsView>(), SearchSuggestionsPresenter {

    private val searchSuggestionsAdapter = SearchSuggestionsAdapter {
        searchPresenterListener.onSearchSuggestionSelected(it)
    }

    override fun loadSearchSuggestions() {
        val suggestionsList = createSuggestionsList()
        searchSuggestionsAdapter.setItems(suggestionsList)
    }

    private fun createSuggestionsList(): ArrayList<SearchSuggestionViewModel> {
        val suggestionsList = arrayListOf<SearchSuggestionViewModel>()
        suggestionsList.add(SearchSuggestionViewModel("Jazz", R.color.orange))
        suggestionsList.add(SearchSuggestionViewModel("Rock", R.color.red))
        suggestionsList.add(SearchSuggestionViewModel("Pop", R.color.yellow))
        suggestionsList.add(SearchSuggestionViewModel("Latino", R.color.green))
        return suggestionsList
    }

    override fun getSearchSuggestionsAdapter(): SearchSuggestionsAdapter = searchSuggestionsAdapter
}