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
import com.bumptech.glide.Glide
import com.example.myapplicat.R
import com.example.myapplicat.data.model.Model


class FirstFragment : Fragment() {
    private val viewModel by viewModels<FirstViewModel>()
    private var pushBtn: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pushBtn = view.findViewById<Button>(R.id.refresh).apply {
            setOnClickListener {
                viewModel.getCats(requireActivity())
                viewModel.catsLiveData.observe(viewLifecycleOwner, {
                    bind(it)
                })
            }
        }
    }

    private fun bind(cats: List<Model>) {
        val picture = cats[0].picture
        val cat = view?.findViewById<ImageView>(R.id.tv_fragment_name)
        if (cat != null) {
            Glide.with(requireActivity())
                .load(picture)
                .centerCrop()
                .into(cat)
        }
    }
}

