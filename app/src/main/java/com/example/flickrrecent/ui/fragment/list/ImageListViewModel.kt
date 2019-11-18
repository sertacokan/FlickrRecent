package com.example.flickrrecent.ui.fragment.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.flickrrecent.api.RecentImage
import com.example.flickrrecent.paging.RecentImageDataSourceFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class ImageListViewModel : ViewModel() {

    val images: LiveData<PagedList<RecentImage>>

    private val parentJob = Job()
    private val modelSoope = CoroutineScope(Dispatchers.IO + parentJob)

    init {

        val dataSourceFactory = RecentImageDataSourceFactory(modelSoope)

        val pageListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(30)
            .setPrefetchDistance(10)
            .setEnablePlaceholders(false)
            .build()

        images = LivePagedListBuilder(dataSourceFactory, pageListConfig).build()
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}