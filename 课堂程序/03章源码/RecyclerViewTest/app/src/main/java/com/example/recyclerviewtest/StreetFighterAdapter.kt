package com.example.recyclerviewtest

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.Toast

class StreetFighterAdapter(val StreetFighterList: List<StreetFighter>) : RecyclerView.Adapter<StreetFighterAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val StreetFighterImage: ImageView = view.findViewById(R.id.StreetFighterImage)
        val StreetFighterName: TextView = view.findViewById(R.id.StreetFighterName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.streetfighter_character, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val StreetFighter = StreetFighterList[position]
            Toast.makeText(parent.context, "you clicked view ${StreetFighter.name}", Toast.LENGTH_SHORT).show()
        }
        viewHolder.StreetFighterImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val StreetFighter = StreetFighterList[position]
            Toast.makeText(parent.context, "you clicked image ${StreetFighter.name}", Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val StreetFighter = StreetFighterList[position]
        holder.StreetFighterImage.setImageResource(StreetFighter.imageId)
        holder.StreetFighterName.text = StreetFighter.name
    }

    override fun getItemCount() = StreetFighterList.size

}
