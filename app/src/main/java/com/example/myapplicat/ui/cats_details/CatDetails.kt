package com.example.myapplicat.ui.cats_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplicat.R
import com.example.myapplicat.data.model.ModelCategories

class CatDetails : Fragment() {
    private val viewModel by viewModels<CatDetailsViewModel>()
    val nameCat = view?.findViewById<TextView>(R.id.name_cat_desc)
    val origin = view?.findViewById<TextView>(R.id.origin_cat_desc)
    val description = view?.findViewById<TextView>(R.id.description_cat_desc)
    val temperament = view?.findViewById<TextView>(R.id.temperament_cat_desc)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.cat_details, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val catId = arguments?.getString(CAT_ID)
        viewModel.getDetCats(requireActivity(), catId)
        initObserver(catId)
    }

    private fun initObserver(CatId: String?) {
        viewModel.catsDetLiveData.observe(viewLifecycleOwner, {
            bind(it)
        })
    }

    private fun bind(cats: List<ModelCategories>) {
        nameCat!!.text = cats[0].name
        origin!!.text = cats[0].origin
        temperament!!.text = cats[0].temperament
        description!!.text = cats[0].description

    }

    companion object {
        private const val CAT_ID = "movie"
        fun newInstance(catPreview: String): CatDetails {
            val fragment = CatDetails()
            val args = Bundle()
            args.putString(CAT_ID, catPreview)
            fragment.arguments = args
            return fragment
        }
    }
}