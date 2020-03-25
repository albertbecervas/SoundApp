package com.soundapp.feature_search.main.presentation.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenter

class SearchFragmentFactory(private val presenter: SearchPresenter) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragment = SearchFragment()
        fragment.injectPresenter(presenter)
        return fragment
    }
}