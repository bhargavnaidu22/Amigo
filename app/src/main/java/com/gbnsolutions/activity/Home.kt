package com.gbnsolutions.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Home : AppCompatActivity() {
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var frameLayout: FrameLayout
    var previousMenuItem: MenuItem ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        drawerLayout = findViewById(R.id.drawerlayout)
//        navigationView = findViewById(R.id.navigationView)
//        toolbar = findViewById(R.id.toolbar)
//        coordinatorLayout = findViewById(R.id.coordinatelayout)
//        frameLayout = findViewById(R.id.frame)
//        setUPtoolbar()
//        openHome()
//        val actionBarDrawerToggle = ActionBarDrawerToggle(
//            this@Home,
//            drawerLayout,
//            R.string.open_drawer,
//            R.string.close_drawer
//        )

//        drawerLayout.addDrawerListener(actionBarDrawerToggle)
//        actionBarDrawerToggle.syncState()
//
//        navigationView.setNavigationItemSelectedListener {
//
//            if (previousMenuItem != null){
//                previousMenuItem?.isChecked = false
//            }
//
//            it.isCheckable = true
//            it.isChecked = true
//            previousMenuItem = it
//
//            when(it.itemId){
//                R.id.home -> {
//                    openHome()
//                    drawerLayout.closeDrawers()
//                }
//                R.id.files -> {
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.frame, FilesFragment())
//                        .commit()
//                    supportActionBar?.title = "Profile"
//                    drawerLayout.closeDrawers()
//                }
//            }
//            return@setNavigationItemSelectedListener true
//        }
    }

//    fun setUPtoolbar(){
//        setSupportActionBar(toolbar)
//        supportActionBar?.title = "Shareit"
//        supportActionBar?.setDisplayShowHomeEnabled(true)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val id = item.itemId
//
//        if (id == android.R.id.home){
//            drawerLayout.openDrawer(GravityCompat.START)
//        }
//        return super.onOptionsItemSelected(item)
//    }

//    fun openHome() {
//        val fragment = HomeFragment()
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.frame, fragment)
//        transaction.commit()
//        supportActionBar?.title = "Home"
//        navigationView.setCheckedItem(R.id.home)
//    }

//    override fun onBackPressed() {
//        val frag = supportFragmentManager.findFragmentById(R.id.frame)
//        when(frag){
//            !is HomeFragment -> openHome()
//
//            else-> super.onBackPressed()
//        }
//    }
}