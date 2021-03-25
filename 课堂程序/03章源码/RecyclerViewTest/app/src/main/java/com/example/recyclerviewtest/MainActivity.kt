package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val StreetFighterList = ArrayList<StreetFighter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initStreetFighters() // 初始化街霸数据
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        val adapter = StreetFighterAdapter(StreetFighterList)
        recyclerView.adapter = adapter
    }

    private fun initStreetFighters() {
        repeat(2) {
            StreetFighterList.add(StreetFighter(getRandomLengthName("Street Fighter IV"), R.drawable.streetfighter4))
            StreetFighterList.add(StreetFighter(getRandomLengthName("Ryu"), R.drawable.ryu))
            StreetFighterList.add(StreetFighter(getRandomLengthName("Ken"), R.drawable.ken))
            StreetFighterList.add(StreetFighter(getRandomLengthName("Chun Li"), R.drawable.chunli))
            StreetFighterList.add(StreetFighter(getRandomLengthName("Guile"), R.drawable.guile))
            StreetFighterList.add(StreetFighter(getRandomLengthName("E.Honda"), R.drawable.honda))
            StreetFighterList.add(StreetFighter(getRandomLengthName("Blanka"), R.drawable.blanka))
            StreetFighterList.add(StreetFighter(getRandomLengthName("Abel"), R.drawable.abel))
        }
    }

    private fun getRandomLengthName(name: String): String {
        val length = Random().nextInt(20) + 1
        val builder = StringBuilder()
        for (i in 0 until length) {
            builder.append(name)
        }
        return builder.toString()
    }

    /*private val StreetFighterList = ArrayList<StreetFighter>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initStreetFighters() // 初始化街霸数据
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager
        val adapter = StreetFighterAdapter(StreetFighterList)
        recyclerView.adapter = adapter
    }
    private fun initStreetFighters() {
        repeat(2) {
            StreetFighterList.add(StreetFighter("Street Fighter IV", R.drawable.streetfighter4))
            StreetFighterList.add(StreetFighter("Ryu", R.drawable.ryu))
            StreetFighterList.add(StreetFighter("Ken", R.drawable.ken))
            StreetFighterList.add(StreetFighter("Chun Li", R.drawable.chunli))
            StreetFighterList.add(StreetFighter("Guile", R.drawable.guile))
            StreetFighterList.add(StreetFighter("E.Honda", R.drawable.honda))
            StreetFighterList.add(StreetFighter("Blanka", R.drawable.blanka))
            StreetFighterList.add(StreetFighter("Abel", R.drawable.abel))
        }
    }*/


}
