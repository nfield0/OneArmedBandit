package com.example.onearmedbandit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class StatisticsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)


        val spinCount = intent.getIntExtra("spinCount",0)
        val winCount = intent.getIntExtra("winCount",0)
        val winLossRatio = intent.getDoubleExtra("winLossRatio",0.0)
        Log.d("spins IN STATS:", spinCount.toString())



        val numSpinsView: TextView = findViewById(R.id.numSpins)
        val numWinsView: TextView = findViewById(R.id.numWins)
        val winLossRatioView: TextView = findViewById(R.id.winLossRatio)
        numSpinsView.text = "$spinCount"
        numWinsView.text = "$winCount"
        winLossRatioView.text =  String.format("%.4f", winLossRatio)
    }
}