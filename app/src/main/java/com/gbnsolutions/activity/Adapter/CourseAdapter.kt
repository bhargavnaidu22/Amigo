package com.gbnsolutions.activity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gbnsolutions.activity.Model.CourseList
import com.gbnsolutions.activity.R

class CourseAdapter(val context: Context,val courselist: ArrayList<CourseList>) :
        RecyclerView.Adapter<CourseAdapter.course>(){
            class course(view: View):RecyclerView.ViewHolder(view){
                val crsTitle: TextView = view.findViewById(R.id.coursetitle)
                val crsDesc: TextView = view.findViewById(R.id.coursedesc)
                val crsImg: ImageView = view.findViewById(R.id.courseimg)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): course {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_course_recycler,parent,false)
        return course(view)
    }

    override fun onBindViewHolder(holder: course, position: Int) {
        val crs: CourseList = courselist[position]
        holder.crsTitle.text = crs.getcoursetitle()
        holder.crsDesc.text = crs.getcoursedesc()
        Glide.with(context).load(crs.getcourseimg())
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.crsImg)
    }

    override fun getItemCount(): Int {
        return courselist.size
    }
}