package com.zhou.gank.adatper

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by zhou on 2017/10/25.
 */
class GankVpAdatper(fm: FragmentManager, var fragmentList: ArrayList<Fragment>, var titleList: ArrayList<String>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titleList[position]
    }
}