package com.example.flickrrecent.adapters

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.flickrrecent.api.RecentImage
import com.example.flickrrecent.listeners.ImageSelectionListener
import com.example.flickrrecent.viewholder.ImageViewHolder

class ImageListAdapter(private val selectionListener: ImageSelectionListener) :
    PagedListAdapter<RecentImage, ImageViewHolder>(ImageDiffUtil) {

    companion object ImageDiffUtil : DiffUtil.ItemCallback<RecentImage>() {
        override fun areItemsTheSame(
            oldItem: RecentImage,
            newItem: RecentImage
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RecentImage,
            newItem: RecentImage
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position), selectionListener)
    }

}