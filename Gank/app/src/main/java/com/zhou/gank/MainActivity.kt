package com.zhou.gank

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.zhou.gank.fragment.GankFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by zhou on 2017/10/25.
 */
class MainActivity : AppCompatActivity() {
    var nav_postion :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()

    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.draw_open, R.string.draw_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_gank -> {
                    nav_postion = 0
                    Log.e("test", "nava gank click")
                    showFragment()
                    true
                }
                R.id.nav_about -> {
                    nav_postion = 1
                    Log.e("test", "nava aboout click")
                    true
                }
                R.id.nav_setting -> {
                    nav_postion =2
                    Log.e("test", "nava setting click")
                    true
                }
                R.id.nav_test2 -> {
                    Log.e("test", "nava test2 click")
                    true
                }
                R.id.nav_test3 -> {
                    Log.e("test", "nava test3 click")
                    true
                }

                else -> false
            }


        }
    }

    private fun showFragment() {
       var transaction = supportFragmentManager.beginTransaction()
       transaction.replace(R.id.fl_container,GankFragment()).commit()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.meau_tool_bar, menu)
        return true
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.tool1 -> Log.e("test", "tool1 click")
            R.id.tool2 -> Log.e("test", "tool2 click")
            R.id.tool3 -> Log.e("test", "tool3 click")
        }

        return super.onOptionsItemSelected(item)
    }
}