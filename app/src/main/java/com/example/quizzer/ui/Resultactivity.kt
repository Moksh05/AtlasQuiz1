package com.example.quizzer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.quizzer.MainActivity
import com.example.quizzer.R
import com.example.quizzer.utility.Constants

class Resultactivity : AppCompatActivity() {
    private lateinit var finishbutton :Button
    private lateinit var textviewusername :TextView
    private lateinit var textviewscore: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultactivity)

        finishbutton=findViewById(R.id.finishbutton)
        textviewscore=findViewById(R.id.score)
        textviewusername=findViewById(R.id.username)

        textviewusername.text= intent.getStringExtra(Constants.USER_NAME)
        val scored = intent.getIntExtra(Constants.score,0)
        val totalques = intent.getIntExtra(Constants.Totalques,0)
        textviewscore.text= "Your Score : $scored/$totalques "

        finishbutton.setOnClickListener {
            Intent(this@Resultactivity,MainActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}