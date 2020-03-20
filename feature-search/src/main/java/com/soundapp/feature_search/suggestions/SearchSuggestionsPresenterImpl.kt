package com.soundapp.feature_search.suggestions

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_search.main.SearchPresenterListener

class SearchSuggestionsPresenterImpl(private val searchPresenterListener: SearchPresenterListener) :
    BasePresenterImpl<SearchSuggestionsView>(), SearchSuggestionsPresenter {

}