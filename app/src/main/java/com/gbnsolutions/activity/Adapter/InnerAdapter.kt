package com.gbnsolutions.activity.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.gbnsolutions.activity.Activity.Schedule_Viewer
import com.gbnsolutions.activity.Model.TypesofActivities
import com.gbnsolutions.activity.R

class InnerAdapter(val context: Context,val arrayList: ArrayList<TypesofActivities>):
        RecyclerView.Adapter<InnerAdapter.Opt>(){
            class Opt(view: View): RecyclerView.ViewHolder(view){
                val image: ImageView = view.findViewById(R.id.image)
                val textfield: TextView = view.findViewById(R.id.name)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Opt {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.inner_recycler_home,parent,false)
        return Opt(view)
    }

    override fun onBindViewHolder(holder: Opt, position: Int) {
        val Inner = arrayList[position]
        Glide.with(context).load(Inner.getImg())
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.image)
        holder.textfield.text = Inner.getName()
        holder.image.setOnClickListener {
            if (Inner.getActivityname()=="Results"){
                val url = "http://115.241.205.4/examresults/Results.aspx"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                context.startActivity(i)
            }else {
                val ii = Intent(context,Schedule_Viewer::class.java)
                ii.putExtra("url",Inner.getImg())
                ii.putExtra("name",Inner.getName())
                context.startActivity(ii)
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}