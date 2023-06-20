package com.example.quizzer.utility

import com.example.quizzer.R
import com.example.quizzer.model.Questions
import kotlin.random.Random

object Constants {
    const val USER_NAME = "username"
    const val Totalques = "totalques"
    const val score = "corrrectans"
    fun getQuestion(): List<Questions> {
        val questions = mutableListOf<Questions>()

        val ques0 = Questions(
            0, "Which Country's Flag is this?", R.drawable.america,
            "Australia", "Germany", "America", "Azerbaijan", 3
        )
        questions.add(ques0)

        val ques1 = Questions(
            1, "Which Country's Flag is this?", R.drawable.flag_of_azerbaijan,
            "India", "France", "Italy", "Azerbaijan", 4
        )
        questions.add(ques1)

        val ques2 = Questions(
            2, "Which Country's Flag is this?", R.drawable.download,
            "India", "America", "Romania", "Ukraine", 1
        )

        questions.add(ques2)

        val ques3 = Questions(
            3, "Which Country's Flag is this?", R.drawable.poland,
            "China", "France", "Italy", "Poland", 4
        )

        questions.add(ques3)

        val ques4 = Questions(
            4, "Which Country's Flag is this?", R.drawable.france,
            "France", "Rome", "Italy", "Canada", 1
        )
        questions.add(ques4)

        val ques5 = Questions(
            5, "Which Country's Flag is this?", R.drawable.germany,
            "China", "France", "India", "Germany", 4
        )
        questions.add(ques5)

        val ques6 = Questions(
            6, "Which Country's Flag is this?", R.drawable.romania,
            "Italy", "Brazil", "Romania", "Russia", 3
        )
        questions.add(ques6)

        val ques7 = Questions(
            7, "Which Country's Flag is this?", R.drawable.ukraine,
            "Canada", "Japan", "Ukraine", "Pakistan", 3
        )
        questions.add(ques7)

        val ques8 = Questions(
            8, "Which Country's Flag is this?", R.drawable.turkey,
            "Syria", "France", "Poland", "Turkey", 4
        )
        questions.add(ques8)

        val ques9 = Questions(
            9, "Which Country's Flag is this?", R.drawable.brazil,
            "Mexico", "Brazil", "Italy", "Denmark", 2
        )
        questions.add(ques9)

        val ques10 = Questions(
            10, "Which Country's Flag is this?", R.drawable.russia,
            "Japan", "Russia", "Afghanistan", "Poland", 2
        )
        questions.add(ques10)

        val ques11 = Questions(
            11, "Which Country's Flag is this?", R.drawable.china,
            "Srilanka", "France", "China", "Bhutan", 3
        )
        questions.add(ques11)

        val indexlist= (0..11).toList().shuffled()
        val finalquestion= mutableListOf<Questions>()
        for (i in 0..9){
            finalquestion.add(questions[indexlist[i]])
        }
        return finalquestion as MutableList<Questions>
    }

}