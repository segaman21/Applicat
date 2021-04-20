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
    lateinit var nameCat: TextView
    lateinit var origin: TextView
    lateinit var description: TextView
    lateinit var temperament : TextView
    lateinit var lifeSpan : TextView

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
        nameCat=view?.findViewById(R.id.name_cat_desc)
        origin = view?.findViewById(R.id.origin_cat_desc)
        description = view?.findViewById(R.id.description_cat_desc)
        temperament = view?.findViewById(R.id.temperament_cat_desc)
        lifeSpan = view?.findViewById(R.id.life_cat_desc)
        val catId = arguments?.getString(CAT_ID)
        viewModel.getDetCats(requireActivity(), catId)
        initObserver(catId)
    }

    private fun initObserver(CatId: String?) {
        viewModel.catsDetLiveData.observe(viewLifecycleOwner, {
            bind(it)
        })
    }

    private fun bind(cats: ModelCategories) {
        nameCat.text = cats.name
        origin.text = cats.origin
        temperament.text = cats.temperament
        description.text = cats.description
        lifeSpan.text = cats.life
    }

    companion object {
        private const val CAT_ID = "cats"
        fun newInstance(catPreview: String): CatDetails {
            val fragment = CatDetails()
            val args = Bundle()
            args.putString(CAT_ID, catPreview)
            fragment.arguments = args
            return fragment
        }
    }
}