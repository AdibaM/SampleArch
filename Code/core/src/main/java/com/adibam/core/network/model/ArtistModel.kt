package com.adibam.core.network.model

/**
 * A class which represents an Artist on Last.fm
 * Some fields aren't used at the moment
 **/
data class ArtistModel(
    val name: String? = null,
    val playcount: Long? = null,
    val listeners: Long? = null,
    val mbid: String? = null,
    val url: String? = null,
    val streamable: Int? = null,
    val image: List<ImageModel>? = null
)