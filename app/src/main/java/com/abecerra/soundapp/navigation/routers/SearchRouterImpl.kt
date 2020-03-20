package com.abecerra.soundapp.navigation.routers

import androidx.fragment.app.FragmentManager
import com.abecerra.soundapp.R
import com.abecerra.soundapp.navigation.navigator.Navigator
import com.soundapp.feature_search.main.presentation.router.SearchRouter
import com.soundapp.feature_search.results.SearchResultsFragment
import com.soundapp.feature_search.suggestions.SearchSuggestionsFragment

class SearchRouterImpl(
    private val navigator: Navigator
) : SearchRouter {
    override fun loadSearchSuggestionsFragment(childFragmentManager: FragmentManager) {

    }

    override fun loadSearchResultsFragment(childFragmentManager: FragmentManager) {
    }

}