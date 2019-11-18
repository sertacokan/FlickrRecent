package com.example.flickrrecent.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.example.flickrrecent.R
import com.example.flickrrecent.adapters.ImageListAdapter
import com.example.flickrrecent.api.RecentImage
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String?) {
    url?.let {
        Picasso.get().load(url)
            .placeholder(R.drawable.ic_placeholder)
            .fit()
            .into(this)
    }
}

@BindingAdapter("imageList")
fun RecyclerView.setImageList(list: PagedList<RecentImage>?) {
    list?.let {
        (adapter as ImageListAdapter).submitList(it)
    }
}
