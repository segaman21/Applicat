
package com.example.myapplicat.ui.cats_list

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplicat.R
import kotlinx.android.synthetic.main.main_fragment.*

class CatsListFragment : Fragment(R.layout.main_fragment) {
    private val viewModel by viewModels<CatsListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val catListAdapter =
            CatsListAdapter(onClick = {
                var bundle = bundleOf("CAT" to it.id, "IMAGE_ID" to it.image?.url)
                findNavController().navigate(
                    R.id.action_to_catDetailsFragment,
                    bundle
                )
            })
        cats_recycler.adapter = catListAdapter
        viewModel.getAllCats(requireActivity())
        viewModel.catsLiveData.observe(viewLifecycleOwner, { animals ->
            catListAdapter.submitList(animals)
        })
    }
}
