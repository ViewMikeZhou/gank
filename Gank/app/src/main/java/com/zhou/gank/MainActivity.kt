package com.zhou.gank

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.zhou.gank.adatper.TestDataAdapter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by zhou on 2017/10/25.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleView.layoutManager = LinearLayoutManager(this)
        var dataList =arrayListOf<String>()
        for (i in 1..100){
            dataList.add("test$i")
        }

        recycleView.adapter =TestDataAdapter(dataList)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
           menuInflater.inflate(R.menu.meau_tool_bar,menu)
        return true
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            R.id.tool1 -> Log.e("test","tool1 click")
            R.id.tool2 -> Log.e("test","tool2 click")
            R.id.tool3 -> Log.e("test","tool3 click")
        }

        return super.onOptionsItemSelected(item)
    }
}