 package com.raccoon.quizza

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        start_button.setOnClickListener {
            if(username_text.getText().toString().equals(""))
            {
                Toast.makeText(this,"Please Enter Username",Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constants.username,username_text.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}