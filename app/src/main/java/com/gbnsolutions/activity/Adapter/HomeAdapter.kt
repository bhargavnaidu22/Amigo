package com.gbnsolutions.activity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gbnsolutions.activity.Model.ListofActivities
import com.gbnsolutions.activity.Model.TypesofActivities
import com.gbnsolutions.activity.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeAdapter(val Activities1: Context, val Activities: ArrayList<ListofActivities>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val Activityname : TextView = view.findViewById(R.id.activity)
        val more: Button = view.findViewById(R.id.viewmore)
        var typesofitems: RecyclerView = view.findViewById(R.id.typesofactivities)
        lateinit var List: ArrayList<TypesofActivities>
        lateinit var Adapter1: InnerAdapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activities: ListofActivities = Activities[position]
        holder.Activityname.text = activities.getActivityname()
        holder.more.setOnClickListener {
            Toast.makeText(Activities1,"Clicked!",Toast.LENGTH_SHORT).show()
        }
        holder.List = arrayListOf<TypesofActivities>()
        val manager: LinearLayoutManager =
            LinearLayoutManager(Activities1,LinearLayoutManager.HORIZONTAL,false)
        holder.typesofitems.layoutManager = manager
        val refUsers = FirebaseDatabase.getInstance().reference.child("Names")
        refUsers.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                (holder.List as ArrayList<TypesofActivities>).clear()
                for (data in snapshot.children){
                    val itemslist: TypesofActivities?= data.getValue(TypesofActivities::class.java)
                    if (itemslist != null) {
                        if (itemslist.getActivityname()==activities.getActivityname()) {
                            (holder.List).add(itemslist)
                        }
                    }
                }
                holder.Adapter1 = InnerAdapter(Activities1,holder.List as ArrayList<TypesofActivities>)
                holder.typesofitems.adapter = holder.Adapter1
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    override fun getItemCount(): Int {
        return Activities.size
    }

}