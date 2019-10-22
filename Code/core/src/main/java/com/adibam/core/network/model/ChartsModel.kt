package com.adibam.core.network.model

/**
 * A class which represents a Last.fm chart
 **/
data class ChartsModel(val artists: ArtistsModel? = null)

data class ArtistsModel(val artist: List<ArtistModel> = emptyList())

