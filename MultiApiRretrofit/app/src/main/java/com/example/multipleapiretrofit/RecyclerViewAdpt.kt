package com.example.multipleapiretrofit

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdpt() : RecyclerView.Adapter<RecyclerViewAdpt.MyViewHolder>() {
    var userList = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.recucler_row_list, parent, false)
        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {

        return userList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(userList[position])
        Log.d("RecyclerViewAdpt", "onBindViewHolder: ${userList[position]}")
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtViewName = view.findViewById<TextView>(R.id.txtViewName)
        val txtViewEmail = view.findViewById<TextView>(R.id.txtViewEmail)
        val txtViewStatus = view.findViewById<TextView>(R.id.txtViewStatus)
        fun bind(data: User) {
            txtViewName.text = data.name
            txtViewEmail.text = data.email
            txtViewStatus.text = data.status
        }
    }
}
