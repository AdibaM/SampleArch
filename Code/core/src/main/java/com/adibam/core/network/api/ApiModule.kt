package com.adibam.core.network.api

import com.adibam.core.network.params.ChartsApiParamsBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Very basic api with one service for charts
 * A more complex app could have multiple services
 **/
object ApiModule {

    private val clientBuilder = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

    private val RETROFIT_INSTANCE = Retrofit.Builder()
        .client(clientBuilder.build())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(ChartsRestApi.ENDPOINT)
        .build()

    private fun chartsRestApi(): ChartsRestApi = RETROFIT_INSTANCE.create(ChartsRestApi::class.java)

    fun chartsApiService() = ChartsApiService(chartsRestApi(), ChartsApiParamsBuilder())
}