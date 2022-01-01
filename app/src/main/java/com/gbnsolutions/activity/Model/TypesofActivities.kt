package com.gbnsolutions.activity.Model

class TypesofActivities {
    private var Name: String = ""

    constructor(Name: String) {
        this.Name = Name
    }

    constructor()
    fun getName(): String?{
        return Name
    }
    fun setName(Name: String){
        this.Name = Name
    }
}