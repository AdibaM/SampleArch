package com.adibam.feed.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adibam.core.artist.domain.Artist
import com.adibam.core.artist.ui.ArtistCardView

class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(artist: Artist) {
        val artistView = itemView as ArtistCardView
        artistView.bindView(artist)
    }

}
