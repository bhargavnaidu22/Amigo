package com.gbnsolutions.activity.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gbnsolutions.activity.Activity.NotesMaker
import com.gbnsolutions.activity.Model.NotesMoel
import com.gbnsolutions.activity.R

class NotesAdapter(val context: Context,val noteslist: ArrayList<NotesMoel>) :
    RecyclerView.Adapter<NotesAdapter.notes>(){
        class notes(view: View): RecyclerView.ViewHolder(view){
            val title: TextView = view.findViewById(R.id.rtitle)
            val description: TextView = view.findViewById(R.id.rdesc)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notes {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_recycler,parent,false)
        return notes(view)
    }

    override fun onBindViewHolder(holder: notes, position: Int) {
        val note: NotesMoel = noteslist[position]
        holder.title.text = note.gettitle()
        holder.description.text = note.getdescription()
        holder.description.setOnClickListener {
            context.startActivity(Intent(context,NotesMaker::class.java))
        }
    }

    override fun getItemCount(): Int {
        return noteslist.size
    }
}