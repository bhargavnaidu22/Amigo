package com.gbnsolutions.activity.Fragments

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.gbnsolutions.activity.R
import com.gbnsolutions.activity.util.ConnectionManager
import com.google.android.material.floatingactionbutton.FloatingActionButton


class SupportFragment : Fragment() {
    lateinit var check: Button
    lateinit var more: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_support, container, false)
        more = view.findViewById(R.id.more)
        check = view.findViewById(R.id.check)
        val fab: FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener {
            val nn = "7675027132"
            val i = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$nn?body="))
            i.setPackage("com.whatsapp")
            startActivity(i)
        }
        more.setOnClickListener {
            val url =
                "https://sites.google.com/view/amigogdsc/home?authuser=1"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        check.setOnClickListener {
            if (ConnectionManager().checkConnectivity(activity as Context)){
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Success")
                dialog.setMessage("Internet connected")
                dialog.setPositiveButton("Ok"){ text, Listner->
                    //nothing
                }
                dialog.setNegativeButton("Cancel"){ text, Listner->
                    //nothing
                }
                dialog.create()
                dialog.show()
            }
            else {
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Error")
                dialog.setMessage("Internet not connected")
                dialog.setPositiveButton("Ok"){ text, Listner->
                    //nothing
                }
                dialog.setNegativeButton("Cancel"){ text, Listner->
                    //nothing
                }
                dialog.create()
                dialog.show()
            }
        }
        return view
    }

}