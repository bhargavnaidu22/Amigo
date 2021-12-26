package com.gbnsolutions.activity.Model

class ListofActivities {
    private var Activityname :String = ""
    constructor()
    constructor(Activityname: String) {
        this.Activityname = Activityname
    }
    fun getActivityname() : String?{
        return Activityname
    }
    fun setActivityname(Activityname: String){
        this.Activityname = Activityname
    }
}