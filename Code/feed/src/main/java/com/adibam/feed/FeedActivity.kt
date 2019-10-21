package com.adibam.feed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adibam.core.entities.Artist
import com.adibam.feed.ui.FeedAdapter
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity() {

    //TODO hardcoding now, these will come from a different source
    private val artists = listOf(
        Artist("Party Next door"),
        Artist("Rosalia"),
        Artist("Bad Bunny")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = FeedAdapter(artists)
    }
}
