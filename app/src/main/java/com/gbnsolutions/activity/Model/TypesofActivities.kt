package com.gbnsolutions.activity.Model

class TypesofActivities {
    private var Name: String = ""
    private var Activityname: String = ""
    private var Img: String = ""

    constructor(Name: String,Activity: String, Img: String) {
        this.Name = Name
        this.Activityname = Activityname
        this.Img = Img
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
    fun getImg(): String?{
        return Img
    }
    fun setImg(Img: String){
        this.Img = Img
    }
}