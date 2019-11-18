package com.example.flickrrecent.ui.fragment.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flickrrecent.api.RecentImage

class ImageDetailViewModel : ViewModel() {

    private val _selectedImage = MutableLiveData<RecentImage>()

    val selectedImage: LiveData<RecentImage>
        get() = _selectedImage

    fun setSelectedImage(image: RecentImage?) {
        _selectedImage.value = image
    }
}