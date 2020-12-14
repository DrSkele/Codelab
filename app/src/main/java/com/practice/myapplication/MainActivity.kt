package com.practice.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "Dice Rolled!"

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener{ countUp() }
    }

    private fun rollDice() {
        val randomInt = (1..6).random()
        result_text.text = randomInt.toString()

        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
    }

    private fun countUp() {
        if(result_text.text.toString() !in intArrayOf(1,2,3,4,5,6).map { it.toString() }){
            result_text.text = 1.toString()
            return
        }
        result_text.text = (if ((result_text.text.toString().toInt() + 1) > 6)  1 else result_text.text.toString().toInt() + 1).toString()
    }
}
