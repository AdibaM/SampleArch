package com.adibam.core.repository

import com.adibam.core.network.model.ChartsModel
import io.reactivex.Single

class ChartsApiService {

    fun getTopArtists(): Single<ChartsModel> {
        return Single.error(Throwable())
    }

}