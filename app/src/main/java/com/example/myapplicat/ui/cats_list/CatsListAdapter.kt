package com.example.myapplicat.ui.cats_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicat.data.model.ModelCategories
import com.example.myapplicat.databinding.CatsItemBinding

typealias OnCatClick = (ModelCategories) -> Unit

class CatsListAdapter(private val onClick: OnCatClick) :
    ListAdapter<ModelCategories, CatsListAdapter.CatViewHolder>(CatDiffCallback) {

    class CatViewHolder(private val viewBinding: CatsItemBinding, onClick: OnCatClick) :
        RecyclerView.ViewHolder(viewBinding.root) {
        private var currentCat: ModelCategories? = null

        init {
            viewBinding.imageCat.apply {
                setOnClickListener {
                    currentCat?.let {
                        onClick(it)
                    }
                }
            }
        }

        fun bind(cat: ModelCategories) {
            currentCat = cat
            viewBinding.apply {
                nameTextCat.text = cat.name
                val picture = cat.image
                imageCat.let {
                    Glide.with(itemView)
                        .load(picture?.url)
                        .centerCrop()
                        .into(it)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val viewBinding =
            CatsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(viewBinding, onClick)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = getItem(position)
        holder.bind(cat)
    }
}

object CatDiffCallback : DiffUtil.ItemCallback<ModelCategories>() {
    override fun areItemsTheSame(oldItem: ModelCategories, newItem: ModelCategories): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ModelCategories,
        newItem: ModelCategories
    ): Boolean {
        return oldItem == newItem
    }
}
