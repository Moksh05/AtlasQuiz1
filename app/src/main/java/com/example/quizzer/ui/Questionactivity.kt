package com.example.quizzer.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizzer.R
import com.example.quizzer.model.Questions
import com.example.quizzer.utility.Constants
import android.util.Log as Log

class Questionactivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var flagimage: ImageView
    private lateinit var progressbar: ProgressBar
    private lateinit var textprogress: TextView
    private lateinit var question1: TextView
    private lateinit var choice1: TextView
    private lateinit var choice2: TextView
    private lateinit var choice3: TextView
    private lateinit var choice4: TextView
    private lateinit var checkbutton: Button
    var questioncounter = 0
    lateinit var name :String
    var selectedanswer = 0
    var score=0
    private var answered = false
    private lateinit var currentques: Questions
    private lateinit var questionlist: MutableList<Questions>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionactivity)

        flagimage = findViewById(R.id.flagimage)
        progressbar = findViewById(R.id.progressBar)
        textprogress = findViewById(R.id.textprogress)
        question1 = findViewById(R.id.questiontitle)
        choice1 = findViewById(R.id.choice1)
        choice2 = findViewById(R.id.choice2)
        choice3 = findViewById(R.id.choice3)
        choice4 = findViewById(R.id.choice4)
        checkbutton = findViewById(R.id.checkbutton)

        choice1.setOnClickListener(this)
        choice2.setOnClickListener(this)
        choice3.setOnClickListener(this)
        choice4.setOnClickListener(this)
        checkbutton.setOnClickListener(this)

        if(intent.hasExtra(Constants.USER_NAME)){
            name = intent.getStringExtra(Constants.USER_NAME).toString()
        }

        questionlist = Constants.getQuestion() as MutableList<Questions>
        Log.d("Question", "${questionlist.size}")
        setQuestion()


    }

    private fun setQuestion() {
        if(questioncounter != questionlist.size){
        resetoption()
        val question = questionlist[questioncounter]
        flagimage.setImageResource(question.image)
        progressbar.progress = questioncounter + 1
        question1.text = question.Question
        textprogress.text = "${questioncounter + 1}/${progressbar.max}"
        choice1.text = (question.Option1)
        choice2.text = question.Option2
        choice3.text = question.Option3
        choice4.text = question.Option4

        checkbutton.text = "Check"
        currentques = questionlist[questioncounter]


        questioncounter++
        }else Intent(this,Resultactivity::class.java).also {
           it.putExtra(Constants.USER_NAME,name)
            it.putExtra(Constants.score,score)
            it.putExtra(Constants.Totalques,questionlist.size)
            startActivity(it)
        }


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.choice1 -> {
                selectedoption(choice1, 1)
            }

            R.id.choice2 -> {
                selectedoption(choice2, 2)
            }

            R.id.choice3 -> {
                selectedoption(choice3, 3)
            }

            R.id.choice4 -> {
                selectedoption(choice4, 4)
            }

            R.id.checkbutton -> {
                if (answered) {
                    checkanswer()
                } else if(selectedanswer==0){
                    Toast.makeText(this,"Please Select an Option",Toast.LENGTH_LONG).show()
                }

                else {
                    selectedanswer=0
                    setQuestion()
                }
            }

        }
    }

    private fun checkanswer() {
        if (selectedanswer == currentques.Correctans) {
            score++
            when (selectedanswer) {
                1 -> {
                    choice1.background =
                        ContextCompat.getDrawable(this, R.drawable.correct_option_border)
                }

                2 -> {
                    choice2.background =
                        ContextCompat.getDrawable(this, R.drawable.correct_option_border)
                }

                3 -> {
                    choice3.background =
                        ContextCompat.getDrawable(this, R.drawable.correct_option_border)
                }

                4 -> {
                    choice4.background =
                        ContextCompat.getDrawable(this, R.drawable.correct_option_border)
                }

            }
        } else {
            when (selectedanswer) {
                1 -> {
                    choice1.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_border)
                }

                2 -> {
                    choice2.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_border)
                }

                3 -> {
                    choice3.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_border)
                }

                4 -> {
                    choice4.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_border)
                }

            }

        }
        choice1.isClickable = false
        choice2.isClickable = false
        choice3.isClickable = false
        choice4.isClickable = false
        answered = false
        if (questioncounter == questionlist.size) {
            checkbutton.text = "Submit"
        } else {
            checkbutton.text = "Next"
        }
    }

    private fun resetoption() {
        val options = mutableListOf<TextView>()
        options.add(choice1)
        options.add(choice2)
        options.add(choice3)
        options.add(choice4)
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.isClickable = true
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_border
            )
        }

    }

    private fun selectedoption(textView: TextView, selectedoption: Int) {
        resetoption()
        selectedanswer = selectedoption
        answered = true
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border
        )

    }

}