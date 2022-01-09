package com.gbnsolutions.activity.Model

class TypesofActivities {
    private var Name: String = ""
    private var Activityname: String = ""

    constructor(Name: String,Activity: String) {
        this.Name = Name
        this.Activityname = Activityname
    }

    constructor()
    fun getName(): String?{
        return Name
    }
    fun setName(Name: String){
        this.Name = Name
    }
    fun getActivityname(): String?{
        return Activityname
    }
    fun setActivity(Activity: String){
        this.Activityname = Activityname
    }
}