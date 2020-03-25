package com.soundapp.feature_search.main.domain.interactor

import com.abecerra.appresources.Translator
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import com.soundapp.feature_commons.domain.model.Song
import com.soundapp.feature_search.main.domain.model.RecentSearch
import com.soundapp.feature_search.main.domain.repository.SearchRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SearchInteractorImplTest {

    @Mock
    private lateinit var repository: SearchRepository

    @Mock
    private lateinit var translator: Translator

    @Mock
    private lateinit var output: SearchInteractorOutput

    @Mock
    private lateinit var searchSuggestionsOutput: SearchInteractorSuggestionsOutput

    @Mock
    private lateinit var searchResultsOutput: SearchInteractorResultOutput

    private lateinit var searchInteractor: SearchInteractorImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(translator.getString(any())).thenReturn("")
        searchInteractor = SearchInteractorImpl(repository, translator)
        searchInteractor.setInteractorOutput(output)
        searchInteractor.setSearchSuggestionsOutput(searchSuggestionsOutput)
        searchInteractor.setSearchResultsOutput(searchResultsOutput)
    }

    @Test
    fun searchSongs() {
        //GIVEN:
        val search = "ozuna"

        //WHEN:
        searchInteractor.searchSongs(search)

        //THEN:
        verify(repository).doSearchCallWithTerm(search)
    }

    @Test
    fun getSortingOptions() {
        //WHEN:
        val options = searchInteractor.getSortingOptions()

        //THEN:
        assert(options.isNotEmpty())
    }

    @Test
    fun getRecentSearches() {
        //WHEN:
        searchInteractor.getRecentSearches()

        //THEN:
        verify(repository).getRecentSearches()
    }

    @Test
    fun removeRecentSearch() {
        //GIVEN:
        val recentSearchToRemove = "ozuna"

        //WHEN:
        searchInteractor.removeRecentSearch(recentSearchToRemove)

        //THEN:
        verify(repository).removeRecentSearch(recentSearchToRemove)
    }

    @Test
    fun getSearchSuggestions() {
        //WHEN:
        val suggestions = searchInteractor.getSearchSuggestions()

        //THEN:
        assert(suggestions.isNotEmpty())
    }

    @Test
    fun onSearchResponseSuccess() {
        //GIVEN:
        val response = arrayListOf<Song>(any())

        //WHEN:
        searchInteractor.onSearchResponse(response)

        //THEN:
        verify(searchResultsOutput).onSearchSongsReceived(response)
    }

    @Test
    fun onSearchResponseError() {
        //GIVEN:
        val response = arrayListOf<Song>()

        //WHEN:
        searchInteractor.onSearchResponse(response)

        //THEN:
        verify(searchResultsOutput).onNoResultsFound()
    }

    @Test
    fun onRecentSearchesResponseWhenRecentSearchesAreFound() {
        //GIVEN:
        val response = arrayListOf(RecentSearch("ozuna"))

        //WHEN:
        searchInteractor.onRecentSearchesResponse(response)

        //THEN:
        verify(searchSuggestionsOutput).onRecentSearchesFound(response)
    }

    @Test
    fun onRecentSearchesResponseWhenRecentSearchesAreNotFound() {
        //GIVEN:
        val response = arrayListOf<RecentSearch>()

        //WHEN:
        searchInteractor.onRecentSearchesResponse(response)

        //THEN:
        verify(searchSuggestionsOutput).onEmptyRecentSearches()
    }
}