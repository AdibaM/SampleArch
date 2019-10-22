package com.adibam.core.network.params

import com.adibam.core.network.api.ChartsRestApi
import com.adibam.core.network.api.ChartsRestApi.Companion.TOP_ARTISTS

private const val METHOD = "method"
private const val API_KEY = "api_key"
private const val FORMAT = "format"
private const val LIMIT = "limit"

class ChartsApiParamsBuilder {

    fun chartsParams(): Map<String, String> {
        return mapOf(
            METHOD to TOP_ARTISTS,
            API_KEY to ChartsRestApi.API_KEY,
            FORMAT to "json",
            LIMIT to "20"
        )
    }
}