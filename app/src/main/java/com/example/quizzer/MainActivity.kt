package com.example.quizzer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import com.example.quizzer.ui.Questionactivity
import com.example.quizzer.utility.Constants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val starbutton = findViewById<Button>(R.id.startbutton)
        val name = findViewById<EditText>(R.id.nameinput)
        starbutton.setOnClickListener {
            if(name.text.isNotEmpty()){
                Intent(this@MainActivity,Questionactivity::class.java).also {
                    it.putExtra(Constants.USER_NAME,name.text.toString())
                    startActivity(it) //tp get into next activity
                    finish() //to get rid of this old activity else it will comeback to this
                }
            }else{
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show() //to represent a prompt if no name given
            }
        }

    }
}