package com.example.myapplicat.ui.cats_details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.myapplicat.R
import com.example.myapplicat.data.model.ModelCategories
import com.example.myapplicat.databinding.DetailsFragmentBinding
import kotlinx.android.synthetic.main.details_fragment.*

class CatDetailsFragment : Fragment() {
    private val viewModel by viewModels<CatDetailsViewModel>()
    private var _binding: DetailsFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val catId = arguments?.getString("CAT")
        viewModel.getCatDetails(requireActivity(), catId)
        viewModel.catsDetLiveData.observe(viewLifecycleOwner, {
            bind(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    private fun bind(cats: ModelCategories) {
        binding?.nameText?.text = cats.name
        binding?.originText?.text = cats.origin
        binding?.descriptionText?.text = cats.description
        binding?.lifeText?.text = cats.life
        val picture = cats.image
        cat_picture.let {
            Glide.with(this)
                .load(picture?.url)
                .centerCrop()
                .into(it)
        }
    }
}