package com.soundapp.feature_search.main.presentation.view

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
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
import com.soundapp.feature_commons.domain.PlaylistInteractor
import com.soundapp.feature_search.MockWebServerController
import com.soundapp.feature_search.R
import com.soundapp.feature_search.RecyclerViewMatchers
import com.soundapp.feature_search.RecyclerViewMatchers.Companion.isNotEmpty
import com.soundapp.feature_search.main.data.SearchRepositoryImpl
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor
import com.soundapp.feature_search.main.domain.interactor.SearchInteractorImpl
import com.soundapp.feature_search.main.domain.repository.SearchRepository
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenter
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenterImpl
import com.soundapp.feature_search.main.presentation.router.SearchRouter
import com.soundapp.feature_search.suggestions.view.RecentSearchesViewHolder
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsFragment
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsFragmentFactory
import com.soundapp.network.services.music.MusicService
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class SearchFragmentTest {

    @Mock
    private lateinit var searchesDao: SearchesDao

    @Mock
    private lateinit var playlistInteractor: PlaylistInteractor

    @Mock
    private lateinit var searchRouter: SearchRouter

    private lateinit var translator: Translator

    private lateinit var musicService: MusicService

    private lateinit var repository: SearchRepository

    private lateinit var interactor: SearchInteractor

    private lateinit var presenter: SearchPresenter

    private val defaultNetworkDelay = 3000L

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        translator = TranslatorImpl(InstrumentationRegistry.getInstrumentation().context)
        musicService = MockWebServerController.buildMockedService(MusicService::class.java)
        repository = SearchRepositoryImpl(musicService, searchesDao)
        interactor = SearchInteractorImpl(repository, translator)
        presenter =
            SearchPresenterImpl(searchRouter, interactor, playlistInteractor)
    }

    @Test
    fun testSuggestionsFragmentIsShownAtStart() {
        launchFragmentInContainer<SearchFragment>(
            factory = SearchFragmentFactory(presenter)
        )

        onView(withId(R.id.layout_suggestions)).check(matches(isDisplayed()))
    }

    @Test
    fun testOnSearchResultsUpdatesRecentSearches() {
        //GIVEN:
        getSearchResponseJson()?.let {
            MockWebServerController.setUpOkResponseWithBody(it)
        }
        setUpRecentSearchesFound()
        launchFragmentInContainer<SearchFragment>(
            factory = SearchFragmentFactory(presenter)
        )

        //WHEN:
        onView(withId(R.id.et_search)).perform(ViewActions.replaceText("ozuna"))
        onView(withId(R.id.et_search)).perform(ViewActions.pressImeActionButton())

        //THEN:
        CountDownLatch(1).await(defaultNetworkDelay, TimeUnit.MILLISECONDS)
        onView(withId(R.id.rv_recently_listened)).check(matches(isNotEmpty()))
    }

    @Test
    fun testOnResultSelectedNavigatesToDetail() {
        //GIVEN:
        getSearchResponseJson()?.let {
            MockWebServerController.setUpOkResponseWithBody(it)
        }
        launchFragmentInContainer<SearchFragment>(
            factory = SearchFragmentFactory(presenter)
        )

        //WHEN:
        onView(withId(R.id.et_search)).perform(ViewActions.replaceText("ozuna"))
        onView(withId(R.id.et_search)).perform(ViewActions.pressImeActionButton())
        CountDownLatch(1).await(defaultNetworkDelay, TimeUnit.MILLISECONDS)
        onView(withId(R.id.rv_search_results)).perform(
            actionOnItemAtPosition<RecentSearchesViewHolder>(0, click())
        )

        //THEN:
        verify(searchRouter).onSearchResultClicked(any())
    }

    private fun getSearchResponseJson(): String? {
        return readFile("search_response")
    }

    private fun readFile(fileName: String): String? {
        val fileInput = this.javaClass.classLoader?.getResourceAsStream(fileName)
        return fileInput?.bufferedReader().use { it?.readText() }
    }

    private fun setUpRecentSearchesFound() {
        doAnswer {
            (it.arguments[0] as? (list: List<RecentSearchEntity>) -> Unit)?.invoke(
                arrayListOf(RecentSearchEntity("Ozuna"), RecentSearchEntity("Daddy"))
            )
        }.whenever(searchesDao).findRecentSearches(any())
    }
}