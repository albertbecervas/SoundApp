package com.abecerra.soundapp.navigation.routers

import androidx.fragment.app.FragmentManager
import com.abecerra.soundapp.R
import com.abecerra.soundapp.navigation.navigator.Navigator
import com.soundapp.feature_search.main.presentation.router.SearchRouter
import com.soundapp.feature_search.suggestions.SearchSuggestionsFragment

class SearchRouterImpl(
    private val navigator: Navigator,
    private val searchSuggestionsFragment: SearchSuggestionsFragment
) : SearchRouter {
    override fun loadSearchSuggestionsFragment(childFragmentManager: FragmentManager) {
        navigator.replaceFragment(searchSuggestionsFragment, R.id.fl_search, childFragmentManager)
    }
}