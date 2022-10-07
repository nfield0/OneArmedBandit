package com.example.onearmedbandit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val onCreate = "OnCreate"
    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(onCreate,"OnCreate Entered")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{ roll()}
        val instructionsButton: Button = findViewById(R.id.instructions)
        instructionsButton.setOnClickListener{
            val intent = Intent(this, InstructionsActivity::class.java)
            startActivity(intent)
        }
    }
    private var spinCount = 0
    private var winCount = 0
    private var winLossRatio = 0.0
    private fun roll(){
        spinCount++
        val rolled = "RollCalled"


        val spinner = Spin(4)
        val spin1 = spinner.roll()
        val spin2 = spinner.roll()
        val spin3 = spinner.roll()

        Log.d(rolled, "Random Number 1: " + spin1 + "Random Number 2: " + spin2 + "Random Number 3: " + spin3)

        val spinImage1: ImageView = findViewById(R.id.imageView)
        val spinImage2: ImageView = findViewById(R.id.imageView2)
        val spinImage3: ImageView = findViewById(R.id.imageView3)

        val drawableResource = draw(spin1)
        val drawableResource2 = draw(spin2)
        val drawableResource3 = draw(spin3)

        spinImage1.setImageResource(drawableResource)
        spinImage1.contentDescription = spin1.toString()

        spinImage2.setImageResource(drawableResource2)
        spinImage2.contentDescription = spin2.toString()

        spinImage3.setImageResource(drawableResource3)
        spinImage3.contentDescription = spin3.toString()

        val resultImage: ImageView = findViewById(R.id.resultImage)

        if(spin1 == spin2 && spin2 == spin3)
        {
            winCount++
            resultImage.setImageResource(R.drawable.winner)
        }
        else
        {
            resultImage.setImageResource(R.drawable.badluck)
        }

        val numSpinsView: TextView = findViewById(R.id.numSpins)
        val numWinsView: TextView = findViewById(R.id.numWins)
        var winLossRatioView: TextView = findViewById(R.id.winLossRatio)
        numSpinsView.text = "$spinCount"
        numWinsView.text = "$winCount"
        winLossRatio = (winCount.toDouble() / spinCount).toDouble()
        winLossRatioView.text =  String.format("%.4f", winLossRatio)
    }

    private fun draw(num: Int): Int {

        val drawableResource = when(num)
        {
            1-> R.drawable.emoji1
            2-> R.drawable.emoji2
            3-> R.drawable.emoji3
            4 -> R.drawable.emoji4
            else ->R.drawable.emoji1
        }
        return drawableResource
    }


}

class Spin (private val numValues: Int)
{

    fun roll(): Int {
        return (1..numValues).random()
    }
}