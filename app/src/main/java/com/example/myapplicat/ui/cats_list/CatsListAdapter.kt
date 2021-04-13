package com.example.myapplicat.ui.cats_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicat.R
import com.example.myapplicat.data.model.ModelCategories

class CatAdapter(private val catList: List<ModelCategories>) :
    RecyclerView.Adapter<CatViewHolder>() {
    private lateinit var callback: Callback
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cats_list, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(catList[position], this.callback)
    }

    override fun getItemCount(): Int {
        return catList.size
    }

    fun initCallback(callback: CatsList) {
        this.callback = callback
    }

    interface Callback {
        fun startCatDetails(item: ModelCategories)
    }
}

class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.findViewById<TextView>(R.id.name_cat_desc)
    val image = itemView.findViewById<ImageView>(R.id.image_cat)
    fun bind(item: ModelCategories, callback: CatAdapter.Callback) {
        itemView.setOnClickListener {
            callback.startCatDetails(item)
        }
        name.text = item.name
        val picture = item.image
        if (image != null) {
            if (picture != null) {
                Glide.with(itemView)
                    .load(picture.url)
                    .centerCrop()
                    .into(image)
            }
        }
    }
}