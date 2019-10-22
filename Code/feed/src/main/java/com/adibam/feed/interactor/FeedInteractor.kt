package com.adibam.feed.interactor

import com.adibam.core.artist.domain.Artist
import com.adibam.core.artist.mapper.ArtistListMapper
import com.adibam.core.repository.ChartsApiService
import io.reactivex.Scheduler
import io.reactivex.Single

/**
 * This interactor encapsulates the use case for the feed
 * Although it simply fetches data from a single source [ChartsApiService],
 * It could fetch data from multiple sources e.g multiple apis or different layer e.g a repository
 **/
class FeedInteractor(
    private val chartsApi: ChartsApiService,
    private val artistListMapper: ArtistListMapper,
    private val io: Scheduler
) {

    fun getArtists(): Single<List<Artist>> =
        chartsApi.getTopArtists()
            .subscribeOn(io)
            .map { artistListMapper.map(it.artists) }

}