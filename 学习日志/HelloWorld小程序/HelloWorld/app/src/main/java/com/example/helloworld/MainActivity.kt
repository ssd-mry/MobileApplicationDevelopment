package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var score = 0
    private var leftButton : Button? = null
    private var rightButton : Button? = null
    private var scoreTextView : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        leftButton = findViewById<Button>(R.id.button_l)
        rightButton = findViewById<Button>(R.id.button_r)
        scoreTextView = findViewById<TextView>(R.id.textView_score)
        refresh()
    }


    fun lbClick(view: View) {
        val lNum = leftButton?.text?.toString()?.toInt() ?: 0
        val rNum = rightButton?.text?.toString()?.toInt() ?: 0
        if (lNum >= rNum) {
            score++
        } else {
            score--
        }
        refresh()
    }

    fun rbClick(view: View) {
        val lNum = leftButton?.text?.toString()?.toInt() ?: 0
        val rNum = rightButton?.text?.toString()?.toInt() ?: 0
        if (lNum <= rNum) {
            score++
        } else {
            score--
        }
        refresh()
    }

    private fun refresh() {
        scoreTextView?.text = "得分：$score"
        leftButton?.text = Random.nextInt(100).toString()
        rightButton?.text = Random.nextInt(100).toString()
    }
}