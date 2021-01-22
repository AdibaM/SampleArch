package com.adibam.core.network.api

import com.adibam.core.network.model.ChartsModel
import com.adibam.core.network.params.ChartsApiParamsBuilder
import io.reactivex.Single


/**
 * Uses Retrofit to fetch the list of top artists
 **/
class ChartsApiService(
    private val api: ChartsRestApi,
    private val paramsBuilder: ChartsApiParamsBuilder
) {

    fun getTopArtists(): Single<ChartsModel> {
        return api.getTopArtistsChart(paramsBuilder.chartsParams())
    }

    fun getTopTrends(): Single<ChartsModel> {
        return Single.just(ChartsModel(artists = null))
    }

    fun getTopVideos(): Single<ChartsModel> {
        return Single.just(ChartsModel(artists = null))
    }
}