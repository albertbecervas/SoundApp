package com.soundapp.feature_search.main.presentation.router

import androidx.fragment.app.FragmentManager

interface SearchRouter {

    fun loadSearchSuggestionsFragment(childFragmentManager: FragmentManager)

    fun loadSearchResultsFragment(childFragmentManager: FragmentManager)
}