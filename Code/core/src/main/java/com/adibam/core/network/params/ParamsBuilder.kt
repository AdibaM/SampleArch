package com.adibam.core.network.params

import com.adibam.core.network.api.Endpoints

class Params {

    private val params =
        "?method=${Endpoints.TOP_ARTISTS_CHARTS_ENDPOINT}" +
                "&" +
                "api_key=0d38b9dc4dd5c46b0617c11db65d642d" +
                "&" +
                "format=json" +
                "&" +
                "limit=5"
}