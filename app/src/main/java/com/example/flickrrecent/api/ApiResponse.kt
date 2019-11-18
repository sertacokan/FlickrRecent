package com.example.flickrrecent.api

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class RecentImageList(
    @SerializedName("photos") var recentImages: RecentImages?
)

data class RecentImages(
    @SerializedName("photo") var imageList: List<RecentImage>?
)

@Parcelize
data class RecentImage(
    @SerializedName("id") var id: Long?,
    @SerializedName("title") var title: String?,
    @SerializedName("url_c") var url: String?
) : Parcelable
