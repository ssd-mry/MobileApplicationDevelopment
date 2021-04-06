package com.example.uitest2018211915

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//显示信息的Activity
class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //创建Activity
        setContentView(R.layout.activity_message) //加载布局

        //通过控件id获取控件
        val messageView: TextView = findViewById(R.id.textViewMessage)
        val buttonBack: Button = findViewById(R.id.buttonBack)

        val message = intent.getStringExtra("message") //获取从MainActivity中传递过来的用户信息

        messageView.text = message //显示信息

        //点击返回按钮，返回MainActivity
        buttonBack.setOnClickListener {
            finish()
        }
    }

}
