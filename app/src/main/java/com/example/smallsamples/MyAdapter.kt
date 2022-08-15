package com.example.smallsamples

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * (C) Koninklijke Philips N.V., 2022.
 * All rights reserved.
 */
class MyAdapter(val songs: List<Songs>) : RecyclerView.Adapter<MyViewHolder>() {

    /* this create a view holder for the item_view layout*/
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    /* binds the songs data to the item_view layout */
    override fun onBindViewHolder(holder: MyViewHolder,
                                  position: Int) {
        holder.tvTitle.text = songs[position].title
        holder.tvDescription.text = songs[position].description

        var color = "#cccccc"
        if (position % 2 == 0) {
            color = "#EEEEEE"
        }
        holder.container.setBackgroundColor((Color.parseColor(color)))
    }

    override fun getItemCount(): Int {
        return songs.count()
    }
}


class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tvTitle = view.findViewById<TextView>(R.id.tv_title)
    var tvDescription = view.findViewById<TextView>(R.id.tv_description)
    var container = view.findViewById<ConstraintLayout>(R.id.container)

}