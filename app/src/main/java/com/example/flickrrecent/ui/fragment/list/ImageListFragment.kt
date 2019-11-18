package com.example.flickrrecent.ui.fragment.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.flickrrecent.adapters.ImageListAdapter
import com.example.flickrrecent.databinding.FragmentImageListBinding
import com.example.flickrrecent.listeners.ImageSelectionListener

class ImageListFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(ImageListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentImageListBinding.inflate(layoutInflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = ImageListAdapter(
            ImageSelectionListener { selectedImage ->
                findNavController().navigate(
                    ImageListFragmentDirections.actionListFragmentToDetailFragment(selectedImage)
                )
            }
        )

        binding.imageList.run {
            setHasFixedSize(true)
            this.adapter = adapter
        }

        return binding.root
    }


}
