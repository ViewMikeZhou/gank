package com.zhou.gank.gank.p

import android.util.Log
import com.chad.library.adapter.base.App.base.BasePresent
import com.zhou.gank.gank.m.IosBeanResult
import com.zhou.gank.gank.v.BaseGankView
import com.zhou.gank.retrofit.Api
import com.zhou.gank.retrofit.RetrofitHelp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by zhou on 2017/10/26.
 */
class IosPrestentK : BasePresent<BaseGankView>() {
    override fun loadMore() {
        Log.e("test","IosPrestentK --- loadMore")
    }

    override fun loadData() {
        Log.e("test","ios ->response ->")
        IBseView.get()?.showProgress()
        RetrofitHelp.instance.retrofit.create(Api::class.java).iosData.enqueue(object : Callback<IosBeanResult> {
            override fun onFailure(call: Call<IosBeanResult>?, t: Throwable?) {
                Log.e("test", "fail")

            }

            override fun onResponse(call: Call<IosBeanResult>?, response: Response<IosBeanResult>?) {
                Log.e("test","ios ->response -> ${response?.body()?.toString()}")
                IBseView.get()?.loadIosData(response?.body()?.iosBeanList!!)
            }
        })
    }
}