package com.example.onearmedbandit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InstructionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions)
        val homeButton: Button = findViewById(R.id.homeButton)


        homeButton.setOnClickListener {finish()}
    }



}