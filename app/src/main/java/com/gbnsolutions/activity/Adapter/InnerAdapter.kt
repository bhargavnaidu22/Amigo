package com.gbnsolutions.activity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gbnsolutions.activity.Model.TypesofActivities
import com.gbnsolutions.activity.R

class InnerAdapter(val context: Context,val arrayList: ArrayList<TypesofActivities>):
        RecyclerView.Adapter<InnerAdapter.Opt>(){
            class Opt(view: View): RecyclerView.ViewHolder(view){
                val image: ImageView = view.findViewById(R.id.image)
                val text: TextView = view.findViewById(R.id.name)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Opt {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.inner_recycler_home,parent,false)
        return Opt(view)
    }

    override fun onBindViewHolder(holder: Opt, position: Int) {
        val Inner = arrayList[position]
        holder.image.setImageResource(R.drawable.ic_launcher_foreground)
        holder.text.text = Inner.getName()
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}