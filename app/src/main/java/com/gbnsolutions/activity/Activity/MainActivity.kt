package com.gbnsolutions.activity.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.gbnsolutions.activity.Home
import com.gbnsolutions.activity.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({main()},3000)
    }
    private fun main(){
        startActivity(Intent(this, Home::class.java))
        finish()
    }
}