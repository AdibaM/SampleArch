package com.adibam.core.network.api

import com.adibam.core.network.model.ChartsModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap


/**
 * Rest API definition for charts from the LastFm Api
 * https://www.last.fm/api/
 **/

interface ChartsRestApi {

    @GET(".")
    fun getTopArtistsChart(@QueryMap options: Map<String, String>): Single<ChartsModel>

    companion object {
        //These values are hardcoded for the purpose of this sample project
        //A different approach would be used for a production ready app
        const val ENDPOINT = "https://ws.audioscrobbler.com/2.0/"
        const val API_KEY = "0d38b9dc4dd5c46b0617c11db65d642d"
        const val TOP_ARTISTS = "chart.gettopartists"
    }

}