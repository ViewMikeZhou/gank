package com.zhou.gank.gank.p

import android.util.Log
import com.chad.library.adapter.base.App.base.BasePresent
import com.zhou.gank.gank.m.AndroidBeanResult
import com.zhou.gank.gank.v.BaseGankView
import com.zhou.gank.retrofit.Api
import com.zhou.gank.retrofit.RetrofitHelp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by zhou on 2017/10/26.
 */
class AndroidPrestentK : BasePresent<BaseGankView>() {

    override fun loadData() {

        IBseView.get()?.showProgress()
        RetrofitHelp.instance.retrofit.create(Api::class.java).androidData.enqueue(object : Callback<AndroidBeanResult> {
            override fun onFailure(call: Call<AndroidBeanResult>?, t: Throwable?) {
                Log.e("test", "fail")

            }
            override fun onResponse(call: Call<AndroidBeanResult>?, response: Response<AndroidBeanResult>?) {
                IBseView.get()?.loadAndroidData(response?.body()?.results!!)
            }
        })
    }

}