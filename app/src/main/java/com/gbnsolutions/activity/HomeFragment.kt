package com.gbnsolutions.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gbnsolutions.activity.Adapter.HomeAdapter
import com.gbnsolutions.activity.Model.ListofActivities

class HomeFragment : Fragment() {
    lateinit var listofactivities: RecyclerView
    lateinit var layoutmanager: RecyclerView.LayoutManager
    lateinit var homeAdapter: HomeAdapter
    lateinit var Activities: ArrayList<ListofActivities>
    lateinit var check: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        listofactivities = view.findViewById(R.id.listofactivities)
        layoutmanager = LinearLayoutManager(activity)
        check = view.findViewById(R.id.print)
        Activities = ArrayList()
        val topic1 = ListofActivities("Schedule")
        Activities.add(topic1)
        val topic2 = ListofActivities("TimeTable")
        Activities.add(topic2)
        val topic3 = ListofActivities("Result")
        Activities.add(topic3)
        val topic4 = ListofActivities("Others")
        Activities.add(topic4)
        listofactivities.adapter = HomeAdapter(Activities)
        listofactivities.layoutManager = layoutmanager
        val abc : ListofActivities = Activities[0]
        check.text = abc.getActivityname()
        return view
    }
}