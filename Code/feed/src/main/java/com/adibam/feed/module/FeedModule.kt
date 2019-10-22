package com.adibam.feed.module

import com.adibam.core.artist.mapper.ArtistListMapper
import com.adibam.core.repository.ChartsApiService
import com.adibam.feed.interactor.FeedInteractor
import com.adibam.feed.viewmodel.FeedViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/*Using manual dependency injection
*/
object FeedModule {

    //Other dependencies will be passed in here so not using the ViewModelProviders approach for now
    fun feedViewModel() = FeedViewModel(feedInteractor(), AndroidSchedulers.mainThread())

    private fun feedInteractor() =
        FeedInteractor(ChartsApiService(), ArtistListMapper(), Schedulers.io())
}