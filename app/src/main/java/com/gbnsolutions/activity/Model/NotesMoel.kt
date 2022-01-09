package com.gbnsolutions.activity.Model

class NotesMoel {
    private var title:String = ""
    private var description: String = ""

    constructor(title: String, description: String) {
        this.title = title
        this.description = description
    }

    constructor()

    fun  gettitle(): String?{
        return title
    }
    fun settitle(title: String){
        this.title = title
    }
    fun getdescription(): String?{
        return description
    }
    fun setdescription(description: String){
        this.description = description
    }

}