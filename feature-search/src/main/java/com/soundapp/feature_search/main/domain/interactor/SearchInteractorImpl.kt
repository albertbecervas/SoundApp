package com.soundapp.feature_search.main.domain.interactor

import com.abecerra.appresources.Translator
import com.abecerra.base.domain.BaseInteractorImpl
import com.soundapp.feature_commons.domain.model.Song
import com.soundapp.feature_search.R
import com.soundapp.feature_search.main.domain.model.RecentSearch
import com.soundapp.feature_search.main.domain.model.SearchSuggestion
import com.soundapp.feature_search.main.domain.model.SortOption
import com.soundapp.feature_search.main.domain.model.SortOption.Companion.DURATION
import com.soundapp.feature_search.main.domain.model.SortOption.Companion.GENRE
import com.soundapp.feature_search.main.domain.model.SortOption.Companion.PRICE
import com.soundapp.feature_search.main.domain.repository.SearchRepository
import com.soundapp.feature_search.main.domain.repository.SearchRepositoryOutput

class SearchInteractorImpl(
    private val searchRepository: SearchRepository,
    private val translator: Translator
) : BaseInteractorImpl<SearchInteractorOutput>(), SearchInteractor, SearchRepositoryOutput {

    private var resultsOutput: SearchInteractorResultOutput? = null

    private var suggestionsOutput: SearchInteractorSuggestionsOutput? = null

    init {
        searchRepository.setRepositoryOutput(this)
    }

    override fun setSearchResultsOutput(resultsOutput: SearchInteractorResultOutput) {
        this.resultsOutput = resultsOutput
    }

    override fun setSearchSuggestionsOutput(suggestionsOutput: SearchInteractorSuggestionsOutput) {
        this.suggestionsOutput = suggestionsOutput
    }

    override fun searchSongs(term: String) {
        searchRepository.doSearchCallWithTerm(term)
    }

    override fun getSortingOptions(): List<SortOption> {
        return arrayListOf(
            SortOption(PRICE, translator.getString(R.string.sort_by_price)),
            SortOption(DURATION, translator.getString(R.string.sort_by_duration)),
            SortOption(GENRE, translator.getString(R.string.sort_by_genre))
        )
    }

    override fun getRecentSearches() {
        searchRepository.getRecentSearches()
    }

    override fun removeRecentSearch(text: String) {
        searchRepository.removeRecentSearch(text)
    }

    override fun getSearchSuggestions(): List<SearchSuggestion> {
        return arrayListOf(
            SearchSuggestion(translator.getString(R.string.jazz), R.color.orange),
            SearchSuggestion(translator.getString(R.string.rock), R.color.red),
            SearchSuggestion(translator.getString(R.string.pop), R.color.yellow),
            SearchSuggestion(translator.getString(R.string.latino), R.color.green)
        )
    }

    override fun <T> preparePlayListFromItemSelected(item: T, list: ArrayList<T>): List<T> {
        list.remove(item)
        list.add(0, item)
        return list
    }

    override fun onSearchResponse(list: List<Song>) {
        if (list.isNotEmpty()) resultsOutput?.onSearchSongsReceived(list)
        else resultsOutput?.onNoResultsFound()
    }

    override fun onRecentSearchesResponse(list: List<RecentSearch>) {
        if (list.isEmpty()) suggestionsOutput?.onEmptyRecentSearches()
        else suggestionsOutput?.onRecentSearchesFound(list)
    }
}