package com.raccoon.quizza

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity() : AppCompatActivity(), View.OnClickListener {

    private var qList:ArrayList<Question>? =null
    private var questionIndex=1
    private var selectedOption=0
    private var correctAns=0
    private var username:String?=null
    private var clickedOption=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        qList=Constants.getQuestions()
        username=intent.getStringExtra(Constants.username)
        setQuestion()

        option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)
        submit_button.setOnClickListener(this)


    }

    private fun setQuestion()
    {

        var question=qList!![questionIndex-1]

        defaultView()
        if(questionIndex==qList!!.size)
            submit_button.text="FINISH"
        else
            submit_button.text="SUBMIT"
        progress_bar.max=qList!!.size
        progress_bar.progress=questionIndex
        progress_text.text="${questionIndex}/${qList!!.size}"

        question_text.text=question!!.questionTitle

        option_one.text=question!!.opt1
        option_two.text=question!!.opt2
        option_three.text=question!!.opt3
        option_four.text=question!!.opt4

        question_image.setImageResource(question.image)
    }

    private fun defaultView()
    {
        var options=ArrayList<TextView>()
        options.add(option_one)
        options.add(option_two)
        options.add(option_three)
        options.add(option_four)

        for(opt in options){
            opt.setTextColor(Color.parseColor("#7A8089"))
            opt.typeface= Typeface.DEFAULT
            opt.background=ContextCompat.getDrawable(this,R.drawable.background_border)

        }
    }

    override fun onClick(v: View?)
    {
        when(v?.id){
            R.id.option_one-> {
                if(!clickedOption) {
                    selectedOption(option_one,1)
                    clickedOption=true
                }
            }
            R.id.option_two->{
                if(!clickedOption) {
                    selectedOption(option_two,2)
                    clickedOption=true
                }
            }
            R.id.option_three->{
                if(!clickedOption) {
                    selectedOption(option_three,3)
                    clickedOption=true
                }
            }
            R.id.option_four->{
                if(!clickedOption) {
                    selectedOption(option_four,4)
                    clickedOption=true
                }
            }
            R.id.submit_button->{
                if(selectedOption==0)
                {
                    ++questionIndex

                    when
                    {
                        questionIndex<=qList!!.size->{
                            setQuestion()
                        clickedOption=false
                        }
                        else-> {
                            val intent=Intent(this,FinishActivity::class.java)
                            intent.putExtra(Constants.username,username)
                            intent.putExtra(Constants.correctAns,correctAns)
                            intent.putExtra(Constants.totalQuestion,qList!!.size)
                            startActivity(intent)
                        }

                    }
                }
                else
                {
                    val question=qList?.get(questionIndex-1)
                    if(question!!.correctAns!=selectedOption) {
                        answerView(selectedOption,R.drawable.background_wrong)
                    }
                    else
                        ++correctAns
                    answerView(question.correctAns,R.drawable.background_correct)
                    submit_button.text="NEXT"
                    selectedOption=0
                }

            }
        }

    }

    private fun answerView(answer:Int, drawableBack:Int)
    {
        when(answer){
            1->{option_one.background=ContextCompat.getDrawable(this,drawableBack)}
            2->{option_two.background=ContextCompat.getDrawable(this,drawableBack)}
            3->{option_three.background=ContextCompat.getDrawable(this,drawableBack)}
            4->{option_four.background=ContextCompat.getDrawable(this,drawableBack)}
        }
    }

    private fun selectedOption(ov:TextView,optNo:Int)
    {
        defaultView()
        selectedOption=optNo

        ov.setTextColor(Color.parseColor("#36363A"))
        ov.setTypeface(ov.typeface,Typeface.BOLD)
        ov.background=ContextCompat.getDrawable(this,R.drawable.selected_border)
    }
}