package com.soundapp.feature_search.suggestions.view

import com.abecerra.base.presentation.BaseView

interface SearchSuggestionsView : BaseView {

    fun showRecents()

    fun hideRecents()
}