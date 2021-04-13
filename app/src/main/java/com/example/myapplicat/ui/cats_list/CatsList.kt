package com.example.myapplicat.ui.cats_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicat.R
import com.example.myapplicat.data.model.ModelCategories
import com.example.myapplicat.ui.cats_details.CatDetails
import kotlinx.android.synthetic.main.recycler_cats.*

class CatsList : Fragment(), CatAdapter.Callback {
    private val viewModel by viewModels<CatsListViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_cats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCats(requireActivity())
        viewModel.catsLiveData.observe(viewLifecycleOwner, {
            val catListAdapter=CatAdapter(it)
            catListAdapter.initCallback(this)

            recyclerCat.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = catListAdapter
            }
        })
    }

    override fun startCatDetails(item: ModelCategories) {
        fragmentManager
        ?.beginTransaction()
            ?.replace(R.id.fragments_container, CatDetails.newInstance(item.id))
            ?.addToBackStack(null)
            ?.commit()
    }
}





