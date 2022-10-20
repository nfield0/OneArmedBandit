package com.example.onearmedbandit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private var spinCount = 0
    private var winCount = 0
    private var winLossRatio = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("HomePage","MainActivity OnCreate called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val instructionsButton: Button = findViewById(R.id.instructions)
        val statsButton: Button = findViewById(R.id.stats)
        val clickMe: TextView = findViewById(R.id.clickMe)
        val topDown = AnimationUtils.loadAnimation(this, R.anim.topdown)

        clickMe.startAnimation(topDown)


        rollButton.setOnClickListener{ spin()}

        instructionsButton.setOnClickListener{
            val intent = Intent(this, InstructionsActivity::class.java)
            startActivity(intent)
        }

        statsButton.setOnClickListener {
            val intent = Intent(this, StatisticsActivity::class.java)
            Log.d("Spin Called: ", spinCount.toString())
            intent.putExtra("spinCount", spinCount)
            intent.putExtra("winCount", winCount)
            intent.putExtra("winLossRatio", winLossRatio)
            startActivity(intent)
        }


    }

    private fun spin(){
        spinCount++
        val spinner = Spin(4)
        val clickMe: TextView = findViewById(R.id.clickMe)
        clickMe.text = ""

        val spinImage1: ImageView = findViewById(R.id.imageView)
        val spinImage2: ImageView = findViewById(R.id.imageView2)
        val spinImage3: ImageView = findViewById(R.id.imageView3)

        val drawableResource = draw(spinner.roll())
        val drawableResource2 = draw(spinner.roll())
        val drawableResource3 = draw(spinner.roll())

        spinImage1.setImageResource(drawableResource)
        spinImage1.contentDescription = drawableResource.toString()

        spinImage2.setImageResource(drawableResource2)
        spinImage2.contentDescription = drawableResource2.toString()

        spinImage3.setImageResource(drawableResource3)
        spinImage3.contentDescription = drawableResource3.toString()

        val resultImage: ImageView = findViewById(R.id.resultImage)

        if(drawableResource == drawableResource2 && drawableResource2 == drawableResource3)
        {
            winCount++
            resultImage.setImageResource(R.drawable.winner)
        }
        else
        {
            resultImage.setImageResource(R.drawable.badluck)
        }

        winLossRatio = (winCount.toDouble() / spinCount)
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

    fun roll(): Int{
        val random = (1..numValues).random()
        Log.d("Random: ", random.toString())
        return random
    }




}