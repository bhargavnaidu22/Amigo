package com.gbnsolutions.activity.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.gbnsolutions.activity.R
import com.zolad.zoominimageview.ZoomInImageView

class Schedule_Viewer : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var img: ZoomInImageView
    lateinit var head: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_viewer)
        toolbar = findViewById(R.id.imgtoolbar)
        img = findViewById(R.id.zimage)
//        img.setImageResource(R.drawable.logo)
        head = findViewById(R.id.head)
        val p = intent.getStringExtra("url")
        val q = intent.getStringExtra("name")
//        Picasso.get().load(p).placeholder(R.drawable.ic_profile).into(img)
        Glide.with(this).load(p)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(img)
        head.setText(q)
        setUpToolbar()
    }
    fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}