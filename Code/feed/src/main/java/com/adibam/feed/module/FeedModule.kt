package com.adibam.feed.module

import com.adibam.feed.viewmodel.FeedViewModel

/*Using manual dependency injection
*/
object FeedModule {

    //Other dependencies will be passed in here so not using the ViewModelProviders approach for now
    fun feedViewModel() = FeedViewModel()
}