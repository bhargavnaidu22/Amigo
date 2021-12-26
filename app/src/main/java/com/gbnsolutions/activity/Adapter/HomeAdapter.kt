package com.gbnsolutions.activity.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gbnsolutions.activity.Model.ListofActivities
import com.gbnsolutions.activity.R

class HomeAdapter(val Activities: ArrayList<ListofActivities>) :RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val Activityname : TextView = view.findViewById(R.id.activity)
        val more: Button = view.findViewById(R.id.viewmore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activities: ListofActivities =Activities[position]
        holder.Activityname.text=activities.getActivityname()
    }

    override fun getItemCount(): Int {
        return Activities.size
    }

}