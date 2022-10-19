package com.example.onearmedbandit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class StatisticsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        val spinCount = intent.getIntExtra("spinCount",0)
        val winCount = intent.getIntExtra("winCount",0)
        val winLossRatio = intent.getDoubleExtra("winLossRatio",0.0)
        Log.d("spins IN STATS:", spinCount.toString())
        val homeButton2: Button = findViewById(R.id.homeButton2)

        homeButton2.setOnClickListener {
            finish()
        }

        val numSpinsView: TextView = findViewById(R.id.numSpins)
        val numWinsView: TextView = findViewById(R.id.numWins)
        val winLossRatioView: TextView = findViewById(R.id.winLossRatio)
        numSpinsView.text = "$spinCount"
        numWinsView.text = "$winCount"
        winLossRatioView.text =  String.format("%.4f", winLossRatio)
    }
}