package com.adibam.feed.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.adibam.core.artist.domain.Artist
import com.adibam.samplearch.feed.interactor.FeedInteractor
import com.adibam.samplearch.feed.viewmodel.FeedViewModel
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class FeedViewModelTest {

    private lateinit var underTest: FeedViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var interactor: FeedInteractor

    @Before
    fun setUp() {
        interactor = mockk()
        underTest =
            FeedViewModel(interactor, Schedulers.trampoline())
    }

    @Test
    fun `Will display list of artists when data is loaded `() {
        val listOfArtists = emptyList<Artist>()
        every { interactor.getArtists() } returns Single.just(listOfArtists)

        underTest.loadTopArtists()

        assertEquals(underTest.feedLiveData().value, listOfArtists)
    }

    @Test
    fun `Will display empty list when data wasn't loaded`() {
        every { interactor.getArtists() } returns Single.error(Throwable())

        underTest.loadTopArtists()

        assertEquals(underTest.feedLiveData().value, emptyList<Artist>())
    }
}