package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        refresh()
    }


    fun lbClick(view: View) {
        val lNum = findViewById<Button>(R.id.button_l).text.toString().toInt()
        val rNum = findViewById<Button>(R.id.button_r).text.toString().toInt()
        if (lNum >= rNum) {
            score++
        } else {
            score--
        }
        refresh()
    }

    fun rbClick(view: View) {
        val lNum = findViewById<Button>(R.id.button_l).text.toString().toInt()
        val rNum = findViewById<Button>(R.id.button_r).text.toString().toInt()
        if (lNum <= rNum) {
            score++
        } else {
            score--
        }
        refresh()
    }

    fun refresh() {
        findViewById<TextView>(R.id.textView_score).text = "得分：$score"
        findViewById<Button>(R.id.button_l).text = Random.nextInt(100).toString()
        findViewById<Button>(R.id.button_r).text = Random.nextInt(100).toString()
    }
}