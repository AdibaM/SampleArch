package com.adibam.feed.interactor

import com.adibam.core.entities.Artist
import io.reactivex.Single

/**
 * This interactor encapsulates the use case for the feed
 * Although it simply fetches data from a single source (FeedRepository),
 * It could fetch data from multiple sources in the future
 **/
class FeedInteractor {

    fun getArtists(): Single<List<Artist>> {
        return Single.error(Throwable())
    }
}