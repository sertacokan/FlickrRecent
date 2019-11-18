package com.example.flickrrecent.api

import com.example.flickrrecent.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecentImageService {

    @GET("rest")
    suspend fun getRecentPhotos(
        @Query("page") pageNumber: Int, //Default 1
        @Query("method") method: String = "flickr.photos.getRecent",
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("per_page") numberOfPhotos: Int = 20,
        @Query("format") format: String = "json",
        @Query("extras") extras: String = "url_c", //	medium 800, 800 on longest side
        @Query("nojsoncallback") noJsonCallback: Int = 1
    ): Response<RecentImageList>
}