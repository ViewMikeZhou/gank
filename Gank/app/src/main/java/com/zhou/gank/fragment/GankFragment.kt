package com.zhou.gank.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import com.zhou.gank.R
import com.zhou.gank.adatper.GankVpAdatper
import com.zhou.gank.base.BaseFrament
import com.zhou.gank.util.GANK_TYPE
import org.jetbrains.anko.find

/**
 * Created by zhou on 2017/10/25.
 */
class GankFragment : BaseFrament() {



    val titlLists :ArrayList<String> by lazy { arrayListOf("test1","test2","test3")}    //懒加载

    override val layoutResId: Int get() = R.layout.fragment_gank

    override fun initView(view: View?) {



        var gank_vp = view?.find<ViewPager>(R.id.gank_vp)
        var gank_tab = view?.find<TabLayout>(R.id.gank_tab)

        var fragmentList = arrayListOf<Fragment>()
        var titleList = arrayListOf<String>("Android", "iOS", "瞎推荐", "扩展资源", "福利", "休息视频")






        titleList.forEach {
            var b = Bundle().apply {
                putString(GANK_TYPE, it)
            }
            fragmentList.add(GankListFrgment.newInstance(b))
        }

        gank_vp?.adapter = GankVpAdatper(childFragmentManager, fragmentList, titleList)
        gank_vp?.offscreenPageLimit = 5
        gank_tab?.setupWithViewPager(gank_vp)


    }


}