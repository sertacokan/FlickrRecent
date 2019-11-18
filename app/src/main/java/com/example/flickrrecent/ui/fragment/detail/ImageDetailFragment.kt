package com.example.flickrrecent.ui.fragment.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.flickrrecent.databinding.FragmentImageDetailBinding

class ImageDetailFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this)[ImageDetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentImageDetailBinding.inflate(layoutInflater, container, false)
        binding.model = viewModel
        binding.lifecycleOwner = this

        val selectedImage = ImageDetailFragmentArgs.fromBundle(arguments!!).selectedImage
        viewModel.setSelectedImage(selectedImage)
        return binding.root
    }


}
