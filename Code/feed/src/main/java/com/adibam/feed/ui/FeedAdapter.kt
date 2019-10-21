package com.adibam.feed.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adibam.core.entities.Artist
import com.adibam.feed.R

class FeedAdapter(private val items: List<Artist>) : RecyclerView.Adapter<FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.feed_item, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(items[position])
    }
}