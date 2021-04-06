package com.example.myapplicat.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicat.R
import com.example.myapplicat.data.model.ModelCategories

class CatAdapter(private val catList: List<ModelCategories>) :
    RecyclerView.Adapter<CatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.first_fragment, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(catList[position])
    }

    override fun getItemCount(): Int {
        return catList.size
    }
}

class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.findViewById<TextView>(R.id.name_cat_desc)
    val origin = itemView.findViewById<TextView>(R.id.origin_cat_desc)
    val temperament = itemView.findViewById<TextView>(R.id.temperament_cat_desc)
    val description = itemView.findViewById<TextView>(R.id.description_cat_desc)
   val image = itemView.findViewById<ImageView>(R.id.image_cat)

    fun bind(item: ModelCategories) {
        name.text = item.name
        origin.text = item.origin
        temperament.text = item.temperament
        description.text = item.description
//             val picture = item.image
//        if (image != null) {
//            Glide.with(itemView)
//                .load(picture)
//                .centerCrop()
//                .into(image)
//        }
    }
}