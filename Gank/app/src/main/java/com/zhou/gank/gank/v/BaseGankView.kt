package com.zhou.gank.gank.v

import com.zhou.gank.gank.m.AndroidBean
import com.zhou.gank.gank.m.IosBean
import com.zhou.gank.gank.m.SuggestBean

/**
 * Created by zhou on 2017/10/26.
 */
interface  BaseGankView {
    fun showProgress()
    fun loadAndroidData(androidBeanList: List<AndroidBean>)
    fun loadIosData(iosBeanList: List<IosBean>)
    fun loadSuggestData(suggestBeanList : List<SuggestBean>)
}