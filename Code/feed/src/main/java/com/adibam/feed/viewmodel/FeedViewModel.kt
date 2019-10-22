package com.adibam.feed.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adibam.core.artist.domain.Artist
import com.adibam.feed.interactor.FeedInteractor
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

class FeedViewModel(private val interactor: FeedInteractor, private val scheduler: Scheduler) :
    ViewModel() {

    private val disposable = CompositeDisposable()

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

    fun loadTopArtists() {
        disposable.add(
            interactor.getArtists()
                .observeOn(scheduler)
                .subscribe(
                    { artistsLiveData.value = it },
                    { artistsLiveData.value = emptyList() }
                )
        )

    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}