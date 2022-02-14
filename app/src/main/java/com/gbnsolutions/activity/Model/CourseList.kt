package com.gbnsolutions.activity.Model

class CourseList {
    private var coursetitle: String =""
    private var coursedesc: String = ""
    private var courseimg: String = ""

    constructor(coursetitle: String, coursedesc: String, courseimg: String) {
        this.coursetitle = coursetitle
        this.coursedesc = coursedesc
        this.courseimg = courseimg
    }

    constructor()

    fun getcoursetitle():String?{
        return coursetitle
    }
    fun setcoursetitle(coursetitle: String){
        this.coursetitle = coursetitle
    }
    fun getcoursedesc():String?{
        return coursedesc
    }
    fun setcoursedesc(coursedesc: String){
        this.coursedesc = coursedesc
    }
    fun getcourseimg():String?{
        return courseimg
    }
    fun setcourseimg(courseimg: String){
        this.courseimg = courseimg
    }
}