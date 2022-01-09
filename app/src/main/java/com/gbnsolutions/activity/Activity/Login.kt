package com.gbnsolutions.activity.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.gbnsolutions.activity.R
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    lateinit var Login: Button
    lateinit var user: EditText
    lateinit var password: EditText
    lateinit var register: TextView
    var userName: String? = null
    var userPassword: String? = null
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        if (intent != null) {
            val i = intent.getStringExtra("logout")
            if (i == "a") {
                editPreferences()
            }
        }
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_login)
        if (isLoggedIn) {
            val i = Intent(this@Login, Home::class.java)
            startActivity(i)
            finish()
        }
        mAuth = FirebaseAuth.getInstance()
        Login = findViewById(R.id.login)
        user = findViewById(R.id.name)
        password = findViewById(R.id.password)
        register = findViewById(R.id.register)
        register.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Login, Register::class.java)
            startActivity(intent)
        })
        Login.setOnClickListener(View.OnClickListener {
            userName = user.getText().toString().trim { it <= ' ' }
            userPassword = password.getText().toString().trim { it <= ' ' }
            if (userName!!.isEmpty()) {
                Toast.makeText(this@Login, "Please enter Email ID", Toast.LENGTH_SHORT)
                    .show()
            } else if (userPassword!!.isEmpty()) {
                Toast.makeText(this@Login, "Please enter Password", Toast.LENGTH_SHORT)
                    .show()
            } else {
                next()
            }
        })
    }
    private operator fun next() {
        mAuth!!.signInWithEmailAndPassword(userName!!, userPassword!!).addOnCompleteListener(
            this@Login
        ) { task ->
            if (task.isSuccessful) {
                Toast.makeText(this@Login, "Logged in Successfully !", Toast.LENGTH_SHORT)
                    .show()
                savePreferences()
                val intent = Intent(this@Login, Home::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@Login, "Invalid Credentials !", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    fun savePreferences() {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
    }

    fun editPreferences() {
        sharedPreferences.edit().putBoolean("isLoggedIn", false).apply()
    }
}