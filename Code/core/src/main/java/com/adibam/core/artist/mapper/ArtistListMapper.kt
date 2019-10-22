package com.adibam.core.artist.mapper

import com.adibam.core.artist.domain.Artist
import com.adibam.core.mapper.Mapper
import com.adibam.core.network.model.ArtistModel

/**
 * A class which maps the [ArtistModel]] server model to an [Artist] model used in the UI layer
 **/
class ArtistListMapper : Mapper<List<ArtistModel>, List<Artist>> {

    override fun map(input: List<ArtistModel>): List<Artist> = input.map { Artist(it.name ?: "") }
}