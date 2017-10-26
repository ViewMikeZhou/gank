package com.zhou.gank.fragment

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.chad.library.adapter.base.App.base.BasePresent
import com.chad.library.adapter.base.baseAdapter.BaseQuickAdapter
import com.chad.library.adapter.base.baseAdapter.BaseViewHolder
import com.zhou.gank.R
import com.zhou.gank.adatper.AndroidDataAdapter
import com.zhou.gank.adatper.IosDataAdapter
import com.zhou.gank.base.BaseLazyFragment
import com.zhou.gank.gank.m.AndroidBean
import com.zhou.gank.gank.m.IosBean
import com.zhou.gank.gank.p.AndroidPrestentK
import com.zhou.gank.gank.p.IosPrestentK
import com.zhou.gank.gank.v.BaseGankView
import com.zhou.gank.util.GANK_TYPE
import org.jetbrains.anko.find

/**
 * Created by zhou on 2017/10/25.
 */
class GankListFrgment : BaseLazyFragment(), BaseGankView {

    var recycleView: RecyclerView? = null
    var refresh: SwipeRefreshLayout? = null
    var basePresent : BasePresent<BaseGankView> ? = null

    companion object {
        fun newInstance(bundle: Bundle): BaseLazyFragment {
            var f = GankListFrgment()
            f.arguments = bundle
            return f
        }
    }


    override val layoutResId get() = R.layout.fragment_gank_list

    override fun initView(view: View?) {
        refresh = view?.find<SwipeRefreshLayout>(R.id.swip_refresh)
        recycleView = view?.find<RecyclerView>(R.id.gank_list_recycle_view)
        recycleView?.layoutManager = LinearLayoutManager(context)
        refresh?.setOnRefreshListener {
            basePresent?.loadData()
        }
    }

    override fun loadData() {
        var type = arguments.getString(GANK_TYPE)
        basePresent = creatPresent(type)
        basePresent?.attachView(this)
        basePresent?.loadData()
    }

    private fun creatPresent(type: String?): BasePresent<BaseGankView>? {
        when (type) {
            "Android" -> {
                //  adapter = AndroidDataAdapter(R.layout.android_data_item, dataList) as BaseQuickAdapter<Int, BaseViewHolder>
                //  recycleView?.adapter = adapter
                return AndroidPrestentK()
            }
            "iOS" -> return IosPrestentK()
        }
        return null
    }

    override fun userUnVisible() {

    }

    override fun showProgress() {
        refresh?.isRefreshing = true
    }

    /**
     * Android 数据
     */
    override fun loadAndroidData(androidBeanList: List<AndroidBean>) {
        var androidAdapter = AndroidDataAdapter(R.layout.android_data_item, androidBeanList) as BaseQuickAdapter<Int, BaseViewHolder>
        loadDataShouldDo(androidAdapter)
    }

    /**
     *  ios 数据
     */
    override fun loadIosData(iosBeanList: List<IosBean>) {
        var iosAdapter = IosDataAdapter(R.layout.android_data_item, iosBeanList) as BaseQuickAdapter<Int, BaseViewHolder>
        loadDataShouldDo(iosAdapter)
    }

    private fun loadDataShouldDo(adapter: BaseQuickAdapter<Int, BaseViewHolder>): Unit {
        refresh?.isRefreshing = false
        adapter.setEnableLoadMore(true)
        adapter.setOnLoadMoreListener({ Log.e("test","android load more")})
        recycleView?.adapter = adapter
        recycleView?.adapter?.notifyDataSetChanged()
    }



}