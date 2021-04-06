package com.example.uitest2018211915

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//主Activity
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //创建Activity
        setContentView(R.layout.activity_main) //加载布局

        //通过控件id获取控件
        val nameEditText: EditText = findViewById(R.id.inputName)
        val ageEditText: EditText = findViewById(R.id.inputAge)
        val heightEditText: EditText = findViewById(R.id.inputHeight)
        val buttonShow: Button = findViewById(R.id.buttonShow)
        val buttonDelete: Button = findViewById(R.id.buttonDelete)

        //点击显示信息按钮，获取用户输入，启动MessageActivity并进行信息传递与显示
        buttonShow.setOnClickListener {
            //获取用户输入
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()
            val height = heightEditText.text.toString()

            if (name == "") { //如果用户未输入姓名，弹出弹窗以提醒用户
                Toast.makeText(this, "您还未输入姓名", Toast.LENGTH_SHORT).show()
            } else if (age == "") { //如果用户未输入年龄，弹出弹窗以提醒用户
                Toast.makeText(this, "您还未输入年龄", Toast.LENGTH_SHORT).show()
            } else if (height == "") { //如果用户未输入身高，弹出弹窗以提醒用户
                Toast.makeText(this, "您还未输入身高", Toast.LENGTH_SHORT).show()
            } else { //如果用户按要求输入信息，启动MessageActivity并进行信息传递与显示
                val intent = Intent(this, MessageActivity::class.java)
                val message = name + age + "岁了，身高是" + height + "米"
                intent.putExtra("message", message)
                startActivity(intent)
            }
        }

        //点击删除显示按钮，清空上方输入框中的内容
        buttonDelete.setOnClickListener {
            nameEditText.text = null
            ageEditText.text = null
            heightEditText.text = null
        }
    }

    //创建并加载菜单栏
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    //点击菜单栏的不同选项，弹出相应弹窗信息以提示用户
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.itemSet -> Toast.makeText(this, "您点击了设置菜单项", Toast.LENGTH_SHORT).show()
            R.id.itemNew -> Toast.makeText(this, "您点击了新建菜单项", Toast.LENGTH_SHORT).show()
            R.id.itemPrint -> Toast.makeText(this, "您点击了打印菜单项", Toast.LENGTH_SHORT).show()
            R.id.itemMail -> Toast.makeText(this, "您点击了邮件菜单项", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}