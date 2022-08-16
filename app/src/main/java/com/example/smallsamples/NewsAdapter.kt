package com.example.smallsamples

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * (C) Koninklijke Philips N.V., 2022.
 * All rights reserved.
 */
class NewsAdapter(val context: Context,
                  val newList: List<Articles>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder,
                                  position: Int) {
        holder.tvTitleNews.text = newList.get(position).title
        holder.tvDescriptionNews.text = newList.get(position).description
        Glide.with(context).load(newList.get(position).urlToImage).into(holder.imgNews)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvTitleNews = view.findViewById<TextView>(R.id.tv_title)
        var tvDescriptionNews = view.findViewById<TextView>(R.id.tv_description)
        var imgNews = view.findViewById<ImageView>(R.id.img_news)
    }
}