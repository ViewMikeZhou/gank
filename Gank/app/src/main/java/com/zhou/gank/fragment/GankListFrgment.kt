package com.zhou.gank.fragment

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.zhou.gank.R
import com.zhou.gank.base.BaseLazyFragment
import com.zhou.gank.util.GANK_TYPE
import org.jetbrains.anko.find

/**
 * Created by zhou on 2017/10/25.
 */
class  GankListFrgment : BaseLazyFragment(){

    companion object {
        fun newInstance(bundle: Bundle):BaseLazyFragment{
            var f =GankListFrgment()
            f.arguments = bundle
            return f
        }
    }


    override val layoutResId get() = R.layout.fragment_gank_list //To change initializer of created properties use File | Settings | File Templates.

    override fun initView(view: View?) {
       var recycleView = view?.find<RecyclerView>(R.id.gank_list_recycle_view)
       var type = arguments.getString(GANK_TYPE)

    }

    override fun loadData() {

    }

    override fun userUnVisible() {

    }




}