package com.zhou.gank.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by zhou on 2017/10/25.
 */
abstract class BaseLazyFragment : Fragment() {
    protected var bIsViewCreated: Boolean = false
    protected var bIsDataLoaded: Boolean = false
    private var mView: View? = null

    /**
     * 布局文件
     */
    protected abstract val layoutResId: Int

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView == null) {      //不重新初始化view
            mView = inflater!!.inflate(layoutResId, container, false)
            initView(mView)
        }
        bIsViewCreated = true
        if (userVisibleHint && !bIsDataLoaded) {
            loadData()
            bIsDataLoaded = true
        }
        return mView
    }


    override fun onDestroyView() {
        super.onDestroyView()
        bIsViewCreated = false
        bIsDataLoaded = false
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && bIsViewCreated && !bIsDataLoaded) {
            bIsDataLoaded = true
            loadData()
        } else if (!isVisibleToUser && bIsDataLoaded) {
            userUnVisible()
        }
    }

    /**
     * 初始化view
     */
    protected abstract fun initView(view: View?)

    /**
     * 加载数据
     */
    protected abstract fun loadData()

    /**
     * 不可见时调用
     */
    protected abstract fun userUnVisible()


}
