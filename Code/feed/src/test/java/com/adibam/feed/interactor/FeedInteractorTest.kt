package com.adibam.feed.interactor

import com.adibam.core.artist.domain.Artist
import com.adibam.core.artist.mapper.ArtistListMapper
import com.adibam.core.network.api.ChartsApiService
import com.adibam.core.network.model.ArtistModel
import com.adibam.core.network.model.ArtistsModel
import com.adibam.core.network.model.ChartsModel
import com.adibam.samplearch.feed.interactor.FeedInteractor
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test

class FeedInteractorTest {

    @MockK
    private lateinit var chartsApi: ChartsApiService

    @MockK
    private lateinit var mapper: ArtistListMapper

    private lateinit var underTest: FeedInteractor

    private val scheduler = Schedulers.trampoline()
    private val testSubscriber = TestObserver<List<Artist>>()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        underTest = FeedInteractor(chartsApi, mapper, scheduler)
    }

    @Test
    fun `Returns artists when call to api is successful`() {
        val listOfArtists = listOf(ArtistModel())
        val artists = listOf(Artist(("")))
        every { chartsApi.getTopArtists() } returns Single.just(
            ChartsModel(
                ArtistsModel(listOfArtists)
            )
        )
        every { mapper.map(listOfArtists) } returns artists

        underTest.getArtists().subscribe(testSubscriber)

        testSubscriber.assertComplete()
        testSubscriber.assertNoErrors()
        testSubscriber.assertValue(artists)
    }

    @Test
    fun `Returns error when call to api is unsuccessful`() {
        val throwable = Throwable()
        every { chartsApi.getTopArtists() } returns Single.error(throwable)

        underTest.getArtists().subscribe(testSubscriber)

        testSubscriber.assertError(throwable)
    }
}
