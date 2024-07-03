package com.example.porterapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(private val itemList: ArrayList<HomeDataCls>): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_vehicle_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.Img.setImageResource(currentItem.Image)
        holder.txt.text = currentItem.name
    }


    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
    val Img :ImageView = itemView.findViewById(R.id.truck)
        val txt :TextView = itemView.findViewById(R.id.nameTruck)
    }
}