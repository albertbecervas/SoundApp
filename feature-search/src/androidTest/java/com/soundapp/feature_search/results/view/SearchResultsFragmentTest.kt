package com.soundapp.feature_search.results.view

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.pressImeActionButton
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import com.abecerra.appresources.Translator
import com.abecerra.appresources.TranslatorImpl
import com.soundapp.database.dao.search.SearchesDao
import com.soundapp.feature_commons.domain.PlaylistInteractor
import com.soundapp.feature_search.MockWebServerController
import com.soundapp.feature_search.R
import com.soundapp.feature_search.RecyclerViewMatchers.Companion.isEmpty
import com.soundapp.feature_search.RecyclerViewMatchers.Companion.isNotEmpty
import com.soundapp.feature_search.main.data.SearchRepositoryImpl
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor
import com.soundapp.feature_search.main.domain.interactor.SearchInteractorImpl
import com.soundapp.feature_search.main.domain.repository.SearchRepository
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenter
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenterImpl
import com.soundapp.feature_search.main.presentation.router.SearchRouter
import com.soundapp.feature_search.main.presentation.view.SearchFragment
import com.soundapp.feature_search.main.presentation.view.SearchFragmentFactory
import com.soundapp.network.services.music.MusicService
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class SearchResultsFragmentTest {

    @Mock
    private lateinit var searchDao: SearchesDao

    @Mock
    private lateinit var playlistInteractor: PlaylistInteractor

    @Mock
    private lateinit var searchRouter: SearchRouter

    private lateinit var translator: Translator

    private lateinit var musicService: MusicService

    private lateinit var repository: SearchRepository

    private lateinit var interactor: SearchInteractor

    private lateinit var presenter: SearchPresenter

    private val defaultNetworkDelay = 2000L

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        translator = TranslatorImpl(InstrumentationRegistry.getInstrumentation().context)
        musicService = MockWebServerController.buildMockedService(MusicService::class.java)
        repository = SearchRepositoryImpl(musicService, searchDao)
        interactor = SearchInteractorImpl(repository, translator)
        presenter =
            SearchPresenterImpl(searchRouter, interactor, playlistInteractor)
    }

    @Test
    fun testSearchResultsSuccessScenario() {
        //GIVEN:
        getSearchResponseJson()?.let {
            MockWebServerController.setUpOkResponseWithBody(it)
        }
        launchFragmentInContainer<SearchFragment>(
            factory = SearchFragmentFactory(presenter)
        )

        //WHEN:
        onView(withId(R.id.et_search)).perform(replaceText("ozuna"))
        onView(withId(R.id.et_search)).perform(pressImeActionButton())

        //THEN:
        CountDownLatch(1).await(defaultNetworkDelay, TimeUnit.MILLISECONDS)
        onView(withId(R.id.rv_search_results)).check(matches(isNotEmpty()))
        onView(withId(R.id.spinner_sort)).check(matches(isDisplayed()))
        onView(withId(R.id.loading)).check(matches(not(isDisplayed())))
    }

    @Test
    fun testSearchResultsErrorScenario() {
        //GIVEN:
        getEmptyResponsesJson()?.let {
            MockWebServerController.setUpOkResponseWithBody(it)
        }
        launchFragmentInContainer<SearchFragment>(
            factory = SearchFragmentFactory(presenter)
        )

        //WHEN:
        onView(withId(R.id.et_search)).perform(replaceText("ozuna"))
        onView(withId(R.id.et_search)).perform(pressImeActionButton())

        //THEN:
        CountDownLatch(1).await(defaultNetworkDelay, TimeUnit.MILLISECONDS)
        onView(withId(R.id.rv_search_results)).check(matches(isEmpty()))
        onView(withId(R.id.spinner_sort)).check(matches(not(isDisplayed())))
        onView(withId(R.id.loading)).check(matches(not(isDisplayed())))
        onView(withId(R.id.tv_empty_results)).check(matches(isDisplayed()))
    }

    @Test
    fun testViewIsClearedWhileSearching() {
        //GIVEN:
        launchFragmentInContainer<SearchFragment>(
            factory = SearchFragmentFactory(presenter)
        )

        //WHEN:
        onView(withId(R.id.et_search)).perform(replaceText("ozuna"))
        onView(withId(R.id.et_search)).perform(pressImeActionButton())

        //THEN:
        onView(withId(R.id.rv_search_results)).check(matches(isEmpty()))
        onView(withId(R.id.spinner_sort)).check(matches(not(isDisplayed())))
        onView(withId(R.id.tv_empty_results)).check(matches(not(isDisplayed())))
    }

    @Test
    fun testSpinnerIsHiddenWhenSearching() {

    }

    private fun getEmptyResponsesJson(): String? {
        return readFile("empty_search_response")
    }

    private fun getSearchResponseJson(): String? {
        return readFile("search_response")
    }

    private fun readFile(fileName: String): String? {
        val fileInput = this.javaClass.classLoader?.getResourceAsStream(fileName)
        return fileInput?.bufferedReader().use { it?.readText() }
    }
}