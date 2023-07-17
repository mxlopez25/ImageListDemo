package com.maloac.imagelistdemo.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maloac.imagelistdemo.R
import com.maloac.imagelistdemo.model.ImageObject

class ImageListAdapter(private val dataSet: List<ImageObject>, private val context: Context): RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvImageName: TextView
        val ivImage: ImageView

        init {
            tvImageName = view.findViewById(R.id.tvImageName)
            ivImage = view.findViewById(R.id.ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvImageName.text = dataSet[position].imageName
        Glide.with(context).load(dataSet[position].imageUrl).into(holder.ivImage)
    }

    override fun getItemCount(): Int = dataSet.size
}