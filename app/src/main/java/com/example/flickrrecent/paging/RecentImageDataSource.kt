package com.example.flickrrecent.paging

import androidx.paging.PageKeyedDataSource
import com.example.flickrrecent.api.RecentImage
import com.example.flickrrecent.api.ServiceBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class RecentImageDataSource(
    private val scope: CoroutineScope
) : PageKeyedDataSource<Int, RecentImage>() {

    companion object {
        private var FIRST_PAGE = 1
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, RecentImage>
    ) {

        scope.launch{
            val response = ServiceBuilder.recentImageService.getRecentPhotos(FIRST_PAGE)

            if (response.isSuccessful) {
                response.body()?.let { recentImageList ->
                    callback.onResult(
                        recentImageList.recentImages?.imageList ?: emptyList(),
                        null,
                        FIRST_PAGE + 1
                    )
                }
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, RecentImage>
    ) {
        scope.launch {
            val response = ServiceBuilder.recentImageService.getRecentPhotos(params.key)

            if (response.isSuccessful) {
                response.body()?.let {
                    callback.onResult(
                        it.recentImages?.imageList ?: emptyList(),
                        params.key + 1
                    )
                }
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, RecentImage>
    ) {
    }
}