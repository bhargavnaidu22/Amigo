package com.gbnsolutions.activity.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.gbnsolutions.activity.R
import com.google.firebase.database.FirebaseDatabase

class NotesMaker : AppCompatActivity() {
    lateinit var title: EditText
    lateinit var description: EditText
    lateinit var add: Button
    lateinit var titleval: String
    lateinit var descriptionval: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_maker)
        title = findViewById(R.id.title)
        description = findViewById(R.id.description)
        add = findViewById(R.id.add)
        titleval  = title.text.toString().trim { it <= ' ' }
        descriptionval = description.text.toString().trim{ it <= ' ' }
        add.setOnClickListener {
            val ref = FirebaseDatabase.getInstance().reference.child("Notes")
            val random: String? =ref.push().key
            val notehashmap =HashMap<String,Any>()
            notehashmap["title"] = title.text.toString().trim { it <= ' ' }
            notehashmap["description"] = description.text.toString().trim { it <= ' ' }
            ref.child(random!!).updateChildren(notehashmap).addOnCompleteListener {task->
                if (task.isSuccessful){
                    Toast.makeText(this,"Note Created",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}