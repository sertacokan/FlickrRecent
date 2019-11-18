package com.example.flickrrecent.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.flickrrecent.api.RecentImage
import kotlinx.coroutines.CoroutineScope

class RecentImageDataSourceFactory(
    private val scope: CoroutineScope
) : DataSource.Factory<Int, RecentImage>() {

    private val _recentImages = MutableLiveData<RecentImageDataSource>()

    val recentImages: LiveData<RecentImageDataSource>
        get() = _recentImages

    override fun create(): DataSource<Int, RecentImage> {
        val dataSource = RecentImageDataSource(scope)
        _recentImages.postValue(dataSource)
        return dataSource
    }
}