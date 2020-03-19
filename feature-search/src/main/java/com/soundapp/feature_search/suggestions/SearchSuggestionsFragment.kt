package com.soundapp.feature_search.suggestions

import android.os.Bundle
import android.view.View
import com.abecerra.base.presentation.BasePresenterFragment
import com.soundapp.feature_search.R

class SearchSuggestionsFragment :
    BasePresenterFragment<SearchSuggestionsPresenter>(R.layout.fragment_search_suggestions),
    SearchSuggestionsView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)
        presenter
    }
}
