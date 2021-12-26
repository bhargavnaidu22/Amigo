package com.gbnsolutions.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gbnsolutions.activity.Adapter.HomeAdapter
import com.gbnsolutions.activity.Model.ListofActivities

class HomeFragment : Fragment() {
    lateinit var listofactivities: RecyclerView
    lateinit var layoutmanager: RecyclerView.LayoutManager
    lateinit var homeAdapter: HomeAdapter
    lateinit var Activities: ArrayList<ListofActivities>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        listofactivities = view.findViewById(R.id.listofactivities)
        layoutmanager = LinearLayoutManager(activity)
        Activities = listOf(ListofActivities("Daily Routine"), ListofActivities("Time Table")) as ArrayList<ListofActivities>
//        homeAdapter = HomeAdapter(Activities = Activities as ArrayList<ListofActivities>)
        listofactivities.adapter = HomeAdapter(Activities)
        listofactivities.layoutManager = layoutmanager
        return view
    }
}