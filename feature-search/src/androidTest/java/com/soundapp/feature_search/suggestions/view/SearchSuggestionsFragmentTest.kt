package com.soundapp.feature_search.suggestions.view

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import com.abecerra.appresources.Translator
import com.abecerra.appresources.TranslatorImpl
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.soundapp.database.dao.search.SearchesDao
import com.soundapp.database.entities.RecentSearchEntity
import com.soundapp.feature_search.R
import com.soundapp.feature_search.RecyclerViewMatchers.Companion.isNotEmpty
import com.soundapp.feature_search.main.data.SearchRepositoryImpl
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor
import com.soundapp.feature_search.main.domain.interactor.SearchInteractorImpl
import com.soundapp.feature_search.main.domain.repository.SearchRepository
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenterListener
import com.soundapp.feature_search.suggestions.presenter.SearchSuggestionsPresenter
import com.soundapp.feature_search.suggestions.presenter.SearchSuggestionsPresenterImpl
import com.soundapp.network.services.music.MusicService
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SearchSuggestionsFragmentTest {

    @Mock
    private lateinit var searchesDao: SearchesDao

    @Mock
    private lateinit var searchPresenterListener: SearchPresenterListener

    @Mock
    private lateinit var musicService: MusicService

    private lateinit var translator: Translator

    private lateinit var repository: SearchRepository

    private lateinit var interactor: SearchInteractor

    private lateinit var searchSuggestionsPresenter: SearchSuggestionsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = SearchRepositoryImpl(musicService, searchesDao)
        translator = TranslatorImpl(InstrumentationRegistry.getInstrumentation().context)
        interactor = SearchInteractorImpl(repository, translator)
        searchSuggestionsPresenter =
            SearchSuggestionsPresenterImpl(searchPresenterListener, interactor)
    }

    @Test
    fun testRecentContentIsDisplayedWhenItExists() {
        // WHEN: Fragment is started and recent searches are found on database
        setUpRecentSearchesFound()
        launchFragmentInContainer<SearchSuggestionsFragment>(
            factory = SearchSuggestionsFragmentFactory(searchSuggestionsPresenter)
        )

        // THEN: A section with recent searches is displayed
        onView(withId(R.id.cl_recently_listened)).check(matches(isDisplayed()))
    }

    @Test
    fun testRecentContentIsNotDisplayedWhenItDoesNotExist() {
        // WHEN: Fragment is started and recent searches are not found on database
        setUpRecentSearchesNotFound()
        launchFragmentInContainer<SearchSuggestionsFragment>(
            factory = SearchSuggestionsFragmentFactory(searchSuggestionsPresenter)
        )

        // THEN: A section with recent searches is not displayed
        onView(withId(R.id.cl_recently_listened)).check(matches(not(isDisplayed())))
    }

    @Test
    fun testSuggestionsViewIsVisibleAndCallsPresenterWhenSelected() {
        // WHEN: Fragment is started
        launchFragmentInContainer<SearchSuggestionsFragment>(
            factory = SearchSuggestionsFragmentFactory(searchSuggestionsPresenter)
        )

        // THEN: Check suggestions list is not empty and when is clicked calls presenter
        // to search content.
        onView(withId(R.id.rv_suggestions)).check(matches(isNotEmpty()))
        onView(withId(R.id.rv_suggestions)).perform(
            actionOnItemAtPosition<SearchSuggestionsViewHolder>(0, click())
        )

        verify(searchPresenterListener).onSearchSuggestionSelected(any())
    }

    private fun setUpRecentSearchesFound() {
        doAnswer {
            (it.arguments[0] as? (list: List<RecentSearchEntity>) -> Unit)?.invoke(
                arrayListOf(RecentSearchEntity("Ozuna"), RecentSearchEntity("Daddy"))
            )
        }.whenever(searchesDao).findRecentSearches(any())
    }

    private fun setUpRecentSearchesNotFound() {
        doAnswer {
            // Do nothing
        }.whenever(searchesDao).findRecentSearches(any())
    }
}