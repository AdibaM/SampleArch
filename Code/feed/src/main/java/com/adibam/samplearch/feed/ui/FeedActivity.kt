package com.adibam.samplearch.feed.ui

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.adibam.core.artist.domain.Artist
import com.adibam.samplearch.feed.R
import com.adibam.samplearch.feed.module.FeedModule
import com.adibam.samplearch.feed.viewmodel.FeedViewModel
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
        recycler_view.visibility = VISIBLE
        recycler_view.adapter = FeedAdapter(artists)
        progress_bar.visibility = GONE
    }
}
