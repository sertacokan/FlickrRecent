package com.example.flickrrecent.listeners

import com.example.flickrrecent.api.RecentImage

class ImageSelectionListener(val listener: (RecentImage) -> Unit) {
    fun onSelected(recentImage: RecentImage) = listener(recentImage)
}