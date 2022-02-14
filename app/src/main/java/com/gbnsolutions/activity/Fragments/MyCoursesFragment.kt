package com.gbnsolutions.activity.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gbnsolutions.activity.Adapter.CourseAdapter
import com.gbnsolutions.activity.Adapter.HomeAdapter
import com.gbnsolutions.activity.Model.CourseList
import com.gbnsolutions.activity.Model.ListofActivities
import com.gbnsolutions.activity.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MyCoursesFragment : Fragment() {
    lateinit var listofcourses: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var courseAdapter: CourseAdapter
    lateinit var courses: ArrayList<CourseList>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_courses, container, false)
        listofcourses = view.findViewById(R.id.courses)
        layoutManager = LinearLayoutManager(activity)
        courses = ArrayList()
        getCourses()
        listofcourses.layoutManager = layoutManager
        return view
    }

    private fun getCourses() {
        val refUsers = FirebaseDatabase.getInstance().reference.child("Courses")
        refUsers.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                (courses as ArrayList<CourseList>).clear()
                for (data in snapshot.children) {
                    val item: CourseList? = data.getValue(CourseList::class.java)
                    courses.add(item!!)
                }
                courseAdapter = CourseAdapter(activity as Context,courses)
                listofcourses.adapter = courseAdapter
                listofcourses.addItemDecoration(
                    DividerItemDecoration(
                        listofcourses.context,
                        (layoutManager as LinearLayoutManager).orientation
                    )
                )
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}