package com.gbnsolutions.activity.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gbnsolutions.activity.Adapter.NotesAdapter
import com.gbnsolutions.activity.Model.NotesMoel
import com.gbnsolutions.activity.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Notes : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var notesrecycler: RecyclerView
    lateinit var new: FloatingActionButton
    lateinit var adapternote: NotesAdapter
    lateinit var noteslist: ArrayList<NotesMoel>
    lateinit var manager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        toolbar = findViewById(R.id.notebar)
        notesrecycler = findViewById(R.id.notes)
        new = findViewById(R.id.new1)
        manager = LinearLayoutManager(this)
        setUPtoolbar()
        noteslist = ArrayList()
        getNotes()
        notesrecycler.layoutManager = manager
        new.setOnClickListener {
            startActivity(Intent(this,NotesMaker::class.java))
        }
    }
    fun getNotes(){
        val ref = FirebaseDatabase.getInstance().reference.child("Notes")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                noteslist.clear()
                for (data in snapshot.children){
                    val note: NotesMoel?= data.getValue(NotesMoel::class.java)
                    noteslist.add(note!!)
                }
                adapternote = NotesAdapter( this@Notes,noteslist)
                notesrecycler.adapter = adapternote
                notesrecycler.addItemDecoration(
                    DividerItemDecoration(
                        this@Notes,
                        (manager as LinearLayoutManager).orientation
                    )
                )
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
    fun setUPtoolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Amigo"
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}