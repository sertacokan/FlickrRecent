package com.example.flickrrecent.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flickrrecent.api.RecentImage
import com.example.flickrrecent.databinding.ImageListItemBinding
import com.example.flickrrecent.listeners.ImageSelectionListener

class ImageViewHolder(private val binding: ImageListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): ImageViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ImageListItemBinding.inflate(layoutInflater, parent, false)
            return ImageViewHolder(binding)
        }
    }

    fun bind(
        recentImage: RecentImage?,
        selectionListener: ImageSelectionListener
    ) {
        binding.run {
            model = recentImage
            listener = selectionListener
            executePendingBindings()
        }
    }
}