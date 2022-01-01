package com.gbnsolutions.activity

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gbnsolutions.activity.Adapter.HomeAdapter
import com.gbnsolutions.activity.Model.ListofActivities
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeFragment : Fragment() {
    lateinit var listofactivities: RecyclerView
    lateinit var layoutmanager: RecyclerView.LayoutManager
    lateinit var HomeAdapter1 : HomeAdapter
    lateinit var Activities: ArrayList<ListofActivities>
    lateinit var check: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        listofactivities = view.findViewById(R.id.listofactivities)
        layoutmanager = LinearLayoutManager(activity)
//        check = view.findViewById(R.id.print)
        Activities = ArrayList()
        getItems()
//        listofactivities.adapter = HomeAdapter(Activities)
        listofactivities.layoutManager = layoutmanager
        return view
    }
    fun getItems(){
        val refUsers = FirebaseDatabase.getInstance().reference.child("Items")
        refUsers.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                (Activities as ArrayList<ListofActivities>).clear()
                for (data in snapshot.children) {
                    val item: ListofActivities? = data.getValue(ListofActivities::class.java)
                    Activities.add(item!!)
                }
                HomeAdapter1 = HomeAdapter(activity as Context,Activities)
                listofactivities.adapter = HomeAdapter1
                listofactivities.addItemDecoration(
                    DividerItemDecoration(
                        listofactivities.context,
                        (layoutmanager as LinearLayoutManager).orientation
                    )
                )
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}