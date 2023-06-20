package com.example.quizzer.model

import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.Drawable

data class Questions(
    val id: Int,
    val Question: String,
    val image: Int,
    val Option1:String,
    val Option2:String,
    val Option3:String,
    val Option4:String,
    val Correctans:Int  //dont know why int maybe later get to know
)
