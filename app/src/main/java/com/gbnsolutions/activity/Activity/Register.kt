package com.gbnsolutions.activity.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.gbnsolutions.activity.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var emailId: EditText
    lateinit var entpassword: EditText
    lateinit var conpassword: EditText
    lateinit var jntu: EditText
    lateinit var register: Button
    lateinit var relogin: TextView
    lateinit var name: String
    lateinit var jntunumber: String
    lateinit var email: String
    lateinit var password: String
    lateinit var confirmpassword: String
    lateinit var mAuth: FirebaseAuth
    private var firebaseUserID: String =""
    lateinit var refUsers: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        username  =findViewById(R.id.editTextUserNameField)
        jntu = findViewById(R.id.jntunumber1)
        emailId = findViewById(R.id.editTextEmailIdField)
        entpassword = findViewById(R.id.editTextPasswordField)
        conpassword = findViewById(R.id.editTextConfirmPasswordField)
        register = findViewById(R.id.buttonRegister)
        relogin = findViewById(R.id.login)
        relogin.setOnClickListener {
            val i = Intent(this@Register,Home::class.java)
            startActivity(i)
        }
        register.setOnClickListener(View.OnClickListener {
            name = username.getText().toString().trim { it <= ' ' }
            jntunumber = jntu.getText().toString().trim { it <= ' ' }
            email = emailId.getText().toString().trim { it <= ' ' }
            password = entpassword.getText().toString().trim { it <= ' ' }
            confirmpassword = conpassword.getText().toString().trim { it <= ' ' }
            if (name.isEmpty()) {
                Toast.makeText(this@Register, "Please enter Name", Toast.LENGTH_SHORT)
                    .show()
            } else if (jntunumber.isEmpty()){
                Toast.makeText(this@Register,"Please enter Jntu Number",Toast.LENGTH_SHORT).show()
            }else if (email.isEmpty()) {
                Toast.makeText(
                    this@Register,
                    "Please enter EMail ID",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (password.isEmpty() && password.length < 8) {
                Toast.makeText(
                    this@Register,
                    "Please enter a Valid password",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (confirmpassword.isEmpty()) {
                Toast.makeText(
                    this@Register,
                    "Please enter COnfirm pasword",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (password != confirmpassword) {
                Toast.makeText(
                    this@Register,
                    "Password and Conf Password should same",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
//                next()
                a()
            }
        })
    }
    private fun a(){
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener (this@Register){
            it-> if (it.isSuccessful){
                firebaseUserID = mAuth.currentUser!!.uid
            refUsers = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseUserID)
            val userHashMap = HashMap<String, Any>()
            userHashMap["uid"] = firebaseUserID
            userHashMap["jntunumber"] = jntu.getText().toString().trim { it <= ' ' }
            userHashMap["name"] = username.getText().toString().trim { it <= ' ' }
            userHashMap["email"] = emailId.getText().toString().trim { it <= ' ' }
            refUsers.updateChildren(userHashMap)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        startActivity(Intent(this@Register,Home::class.java))
                    }else{
                        Toast.makeText(this@Register,"Error",Toast.LENGTH_SHORT).show()
                    }
                }
        }
        }
    }
//    private operator fun next() {
//        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
//            this@Register
//        ) { task ->
//            if (task.isSuccessful) {
//                firebaseUserID = mAuth.currentUser!!.uid
//                refUsers = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseUserID)
//
//                val userHashMap = HashMap<String, Any>()
//                userHashMap["uid"] = firebaseUserID
//                userHashMap["jntunumber"] = jntu.getText().toString().trim { it <= ' ' }
//                userHashMap["name"] = username.getText().toString().trim { it <= ' ' }
//                userHashMap["email"] = emailId.getText().toString().trim { it <= ' ' }
//                refUsers.updateChildren(userHashMap)
//                    .addOnCompleteListener {task->
//                        if (task.isSuccessful){
//                            Toast.makeText(
//                                this@Register,
//                                "User registration successful !",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                            startActivity(Intent(this@Register, Home::class.java))
//                        }
//                    }
//            } else {
//                Toast.makeText(
//                    this@Register,
//                    "Something Wrong Occurred !",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//    }
}