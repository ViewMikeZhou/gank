package com.zhou.gank.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by zhou on 2017/10/25.
 */
abstract class BaseFrament : Fragment(){
    private var mView: View? = null
    protected abstract val layoutResId: Int
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView == null) {      //不重新初始化view
            mView = inflater!!.inflate(layoutResId, container, false)
            initView(mView)
        }
        return mView
    }

    abstract fun initView(mView: View?)
}