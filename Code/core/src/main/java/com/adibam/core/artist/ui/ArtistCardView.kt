package com.adibam.core.artist.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.adibam.core.R
import com.adibam.core.artist.domain.Artist
import kotlinx.android.synthetic.main.artist_card_view.view.*

/**
 * In this sample app, artist cards can be displayed across the app
 * As a result its a good candidate for the core module
 */
class ArtistCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.artist_card_view, this, true)
    }

    fun bindView(artist: Artist) {
        artist_name.text = artist.name
    }
}
