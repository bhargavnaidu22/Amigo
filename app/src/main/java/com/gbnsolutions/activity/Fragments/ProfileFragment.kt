package com.gbnsolutions.activity.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gbnsolutions.activity.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class ProfileFragment : Fragment() {
    lateinit var image: ImageView
    lateinit var email: TextView
    lateinit var uname: TextView
    lateinit var jntunumber: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        image = view.findViewById(R.id.profileimage)
        email = view.findViewById(R.id.email)
        uname = view.findViewById(R.id.pname)
        jntunumber = view.findViewById(R.id.jntunumber)
        val refusers = FirebaseDatabase.getInstance().reference.child("Users").child(FirebaseAuth.getInstance().currentUser!!.uid)

        return view
    }

}