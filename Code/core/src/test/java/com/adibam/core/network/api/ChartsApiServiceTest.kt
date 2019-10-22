package com.adibam.core.network.api

import com.adibam.core.network.model.ChartsModel
import com.adibam.core.network.params.ChartsApiParamsBuilder
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test

class ChartsApiServiceTest {

    @MockK
    private lateinit var chartsApi: ChartsRestApi

    @MockK
    private lateinit var paramsBuilder: ChartsApiParamsBuilder

    private lateinit var underTest: ChartsApiService

    private val testSubscriber = TestObserver<ChartsModel>()

    private val testParams = emptyMap<String, String>()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        every { paramsBuilder.chartsParams() } returns testParams
        underTest = ChartsApiService(chartsApi, paramsBuilder)

    }

    @Test
    fun `Successful call is handled correctly`() {
        val chartsModel = ChartsModel()
        every { chartsApi.getTopArtistsChart(testParams) } returns Single.just(chartsModel)

        underTest.getTopArtists().subscribe(testSubscriber)

        testSubscriber.assertComplete()
        testSubscriber.assertNoErrors()
        testSubscriber.assertValue(chartsModel)
    }

    @Test
    fun `Errors are handled correctly`() {
        val throwable = Throwable()
        every { chartsApi.getTopArtistsChart(testParams) } returns Single.error(throwable)

        underTest.getTopArtists().subscribe(testSubscriber)

        testSubscriber.assertError(throwable)
    }
}