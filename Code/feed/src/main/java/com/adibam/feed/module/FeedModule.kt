package com.adibam.feed.module

import com.adibam.feed.interactor.FeedInteractor
import com.adibam.feed.viewmodel.FeedViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

/*Using manual dependency injection
*/
object FeedModule {

    //Other dependencies will be passed in here so not using the ViewModelProviders approach for now
    fun feedViewModel() = FeedViewModel(FeedInteractor(), AndroidSchedulers.mainThread())
}