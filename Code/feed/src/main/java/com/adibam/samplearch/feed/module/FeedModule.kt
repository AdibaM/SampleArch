package com.adibam.samplearch.feed.module

import com.adibam.core.artist.mapper.ArtistListMapper
import com.adibam.core.network.api.ApiModule.chartsApiService
import com.adibam.samplearch.feed.interactor.FeedInteractor
import com.adibam.samplearch.feed.viewmodel.FeedViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Using manual dependency injection
 */
object FeedModule {

    fun feedViewModel() = FeedViewModel(
        feedInteractor(),
        AndroidSchedulers.mainThread()
    )

    private fun feedInteractor() =
        FeedInteractor(
            chartsApiService(),
            ArtistListMapper(),
            Schedulers.io()
        )
}