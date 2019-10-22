package com.adibam.feed.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.adibam.core.artist.domain.Artist
import com.adibam.feed.R
import com.adibam.feed.module.FeedModule
import com.adibam.feed.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity() {

    private lateinit var viewModel: FeedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        viewModel = FeedModule.feedViewModel()
        viewModel.loadTopArtists()
        viewModel.feedLiveData().observe(this, Observer { displayArtists(it) })
        recycler_view.layoutManager = LinearLayoutManager(this)

    }

    private fun displayArtists(artists: List<Artist>) {
        recycler_view.adapter = FeedAdapter(artists)
    }
}
