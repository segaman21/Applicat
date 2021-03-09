package com.example.myapplicat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cat= view.findViewById<ImageView>(R.id.tv_fragment_name)
        Glide.with(requireActivity())
            .load("https://api.thecatapi.com/v1/images/search")
            .centerCrop()
            .into(cat)
    }


}