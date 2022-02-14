package com.gbnsolutions.activity.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gbnsolutions.activity.Model.Users
import com.gbnsolutions.activity.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ProfileFragment : Fragment() {
    lateinit var image: ImageView
    lateinit var email: TextView
    lateinit var uname: TextView
    lateinit var jntunumber: TextView
    lateinit var users: Users
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        email = view.findViewById(R.id.email)
        uname = view.findViewById(R.id.pname)
        jntunumber = view.findViewById(R.id.jntunumber)
        val refusers = FirebaseDatabase.getInstance().reference.child("Users").child(FirebaseAuth.getInstance().currentUser!!.uid)
        refusers!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    val user: Users?= snapshot.getValue(Users::class.java)
                    uname.text = user!!.getname()
                    email.text = user.getemail()
                    jntunumber.text = user.getjntunumber()
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        return view
    }

}