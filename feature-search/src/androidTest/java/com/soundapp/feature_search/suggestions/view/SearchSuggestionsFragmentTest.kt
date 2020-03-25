package com.soundapp.feature_search.suggestions.view

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import com.abecerra.appresources.Translator
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.whenever
import com.soundapp.database.dao.search.SearchesDao
import com.soundapp.database.entities.RecentSearchEntity
import com.soundapp.feature_search.MockWebServerController
import com.soundapp.feature_search.R
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

    private lateinit var musicService: MusicService

    private lateinit var translator: Translator

    private lateinit var repository: SearchRepository

    private lateinit var interactor: SearchInteractor

    private lateinit var searchSuggestionsPresenter: SearchSuggestionsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        musicService = MockWebServerController.buildMockedService(MusicService::class.java)
        repository = SearchRepositoryImpl(musicService, searchesDao)
        translator = Translator(InstrumentationRegistry.getInstrumentation().context)
        interactor = SearchInteractorImpl(repository, translator)
        searchSuggestionsPresenter =
            SearchSuggestionsPresenterImpl(searchPresenterListener, interactor)
    }

    @Test
    fun testRecentContentIsDisplayedWhenItExists() {
        // WHEN: Recent searches are found on database
        setUpRecentSearchesFound()
        launchFragmentInContainer<SearchSuggestionsFragment>(
            factory = SearchSuggestionsFragmentFactory(searchSuggestionsPresenter)
        )

        // THEN: A section with recent searches is displayed
        onView(withId(R.id.cl_recently_listened)).check(matches(isDisplayed()))
    }

    @Test
    fun testRecentContentIsNotDisplayedWhenItDoesNotExist() {
        // WHEN: Recent searches are not found on database
        setUpRecentSearchesNotFound()
        launchFragmentInContainer<SearchSuggestionsFragment>(
            factory = SearchSuggestionsFragmentFactory(searchSuggestionsPresenter)
        )

        // THEN: A section with recent searches is not displayed
        onView(withId(R.id.cl_recently_listened)).check(matches(not(isDisplayed())))
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

    @Test
    fun showRecents() {
    }

    @Test
    fun hideRecents() {
    }

    private fun getSearchResponseJson(): String? {
        val fileInput = this.javaClass.classLoader?.getResourceAsStream("search_response")
        return fileInput?.bufferedReader().use { it?.readText() }
    }
}