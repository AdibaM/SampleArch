package com.adibam.samplearch.feed.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adibam.core.artist.domain.Artist
import com.adibam.samplearch.feed.interactor.FeedInteractor
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

class FeedViewModel(private val interactor: FeedInteractor, private val scheduler: Scheduler) :
    ViewModel() {

    private val disposable = CompositeDisposable()

    private val artistsLiveData = MutableLiveData<List<Artist>>()

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