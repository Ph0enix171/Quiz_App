package com.raccoon.quizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        username_text_finish.text=intent.getStringExtra(Constants.username)
        final_score.text="${intent.getIntExtra(Constants.correctAns,0)}/${intent.getIntExtra(Constants.totalQuestion,0)}"

        finish_button.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}