package com.example.myapplicat.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplicat.R
import com.example.myapplicat.data.model.Model
import kotlinx.android.synthetic.main.recycler_cats.*


class FirstFragment : Fragment() {
    private val viewModel by viewModels<FirstViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCats(requireActivity())
        viewModel.catsLiveData.observe(viewLifecycleOwner, {
            recyclerCat.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = CatAdapter(it)
            }

        })
    }
}





