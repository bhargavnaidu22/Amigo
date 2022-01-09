package com.gbnsolutions.activity.Model

class Users {
    private var uid: String = ""
    private var jntunumber: String = ""
    private var name: String = ""
    private var email: String = ""

    constructor(uid: String,jntunumber: String, name: String, email: String) {
        this.uid =uid
        this.jntunumber = jntunumber
        this.name = name
        this.email = email
    }

    constructor()

    fun getuid(): String?{
        return uid
    }
    fun setuid(uid: String){
        this.uid = uid
    }
    fun getjntunumber(): String?{
        return jntunumber
    }
    fun setjntunumber(jntunumber: String){
        this.jntunumber = jntunumber
    }
    fun getname(): String?{
        return name
    }
    fun setname(name: String){
        this.name = name
    }
    fun getemail(): String?{
        return email
    }
    fun setemail(email: String){
        this.email = email
    }
}