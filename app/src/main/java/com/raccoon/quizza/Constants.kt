package com.raccoon.quizza

object Constants {
    const val username:String="user_name"
    const val totalQuestion:String="total_questions"
    const val correctAns:String="correct_ans"

    fun getQuestions(): ArrayList<Question> {
        val questionList=ArrayList<Question>()

        val q1 = Question(
            1,
            "Which country's flag is this?",
            R.drawable.canada_flag,
            "Germany",
            "USA",
            "Poland",
            "Canada",
            4
        )
        val q2 = Question(
            1,
            "Which country's flag has a chakra in the middle?",
            R.drawable.india_flag,
            "India",
            "Japan",
            "Russia",
            "Canada",
            1
        )
        val q3 = Question(
            1,
            "This country is known for its animation industry. Identify",
            R.drawable.japan_flag,
            "India",
            "USA",
            "Japan",
            "Poland",
            3
        )
        val q4 = Question(
            1,
            "This country was invaded, thus starting WW2. Which country is being talked about",
            R.drawable.poland_flag,
            "Russia",
            "Poland",
            "USA",
            "Germany",
            2
        )
        val q5 = Question(
            1,
            "This country invaded the answer of the previous question. Which one is it?",
            R.drawable.germany_flag,
            "Germany",
            "India",
            "Russia",
            "USA",
            1
        )

        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)
        return questionList
    }
}