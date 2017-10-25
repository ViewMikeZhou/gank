package com.zhou.gank

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.zhou.gank.fragment.GankFragment
import com.zhou.gank.fragment.SettingFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by zhou on 2017/10/25.
 */
class MainActivity : AppCompatActivity() {
    var nav_postion: Int = 0
    var fragmentList = arrayListOf<Fragment>(GankFragment(), SettingFragment())
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
                R.id.nav_gank -> showFragment(0, it.title.toString())
                R.id.nav_about -> showFragment(1, it.title.toString())
                R.id.nav_setting -> showFragment(1, it.title.toString())
                R.id.nav_test2 -> showFragment(3, it.title.toString())
                R.id.nav_test3 -> showFragment(4, it.title.toString())
                else -> false
            }
        }

        initFristShowFragment()

    }

    private fun initFristShowFragment() {
        var transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_container, fragmentList[0]).commit()
    }

    private fun showFragment(index: Int, title: String): Boolean {
        if (index != nav_postion) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.hide(fragmentList[nav_postion])
            if (!fragmentList[index].isAdded) {
                transaction.add(R.id.fl_container, fragmentList[index])
            }
            transaction.show(fragmentList[index]).commit()
            toolbar.title = title
            nav_postion = index
        }
        drawerLayout.closeDrawers()
        return true


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