package com.adibam.feed.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adibam.core.entities.Artist

class FeedViewModel : ViewModel() {

    //TODO hardcoding now, these will come from a different source
    private val artists = listOf(
        Artist("Party Next door"),
        Artist("Rosalia"),
        Artist("Bad Bunny")
    )

    private val artistsLiveData = MutableLiveData<List<Artist>>()

    init {
        artistsLiveData.value = artists
    }

    fun feedLiveData() = artistsLiveData
}