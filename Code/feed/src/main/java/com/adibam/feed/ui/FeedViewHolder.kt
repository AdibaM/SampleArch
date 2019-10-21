package com.adibam.feed.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adibam.core.entities.Artist

class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(artist: Artist) {
        val view = itemView as TextView
        view.text = artist.name
    }

}
