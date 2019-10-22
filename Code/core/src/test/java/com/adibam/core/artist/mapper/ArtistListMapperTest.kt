package com.adibam.core.artist.mapper

import com.adibam.core.network.model.ArtistModel
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertTrue

class ArtistListMapperTest {

    private val underTest = ArtistListMapper()

    @Test
    fun `Will return empty result when empty list is provided`() {
        assertEquals(0, underTest.map(emptyList()).size)
    }

    @Test
    fun `Will map fields correctly when artist model fields are optional`() {
        val artist = underTest.map(listOf(ArtistModel()))

        assertEquals(1, artist.size)
        assertTrue(artist[0].name.isEmpty())
    }

    @Test
    fun `Will map relevant fields correctly when artist model are present`() {
        val artist = underTest.map(listOf(ArtistModel(name = "Da Baby")))

        assertEquals(1, artist.size)
        assertEquals("Da Baby", artist[0].name)
    }

}