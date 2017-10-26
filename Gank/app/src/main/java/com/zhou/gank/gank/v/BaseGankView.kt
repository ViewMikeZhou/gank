package com.zhou.gank.gank.v

import com.zhou.gank.gank.m.AndroidBean
import com.zhou.gank.gank.m.IosBean

/**
 * Created by zhou on 2017/10/26.
 */
interface  BaseGankView {
    fun showProgress()
    fun loadAndroidData(androidBeanList: List<AndroidBean>)
    fun loadIosData(iosBeanList: List<IosBean>)
}