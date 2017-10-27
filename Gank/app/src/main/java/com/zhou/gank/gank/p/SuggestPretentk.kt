package com.zhou.gank.gank.p

import android.util.Log
import com.chad.library.adapter.base.App.base.BasePresent
import com.zhou.gank.gank.m.SuggestBeanResult
import com.zhou.gank.gank.v.BaseGankView
import com.zhou.gank.retrofit.Api
import com.zhou.gank.retrofit.RetrofitHelp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by zhou on 2017/10/27.
 */
class  SuggestPretentk : BasePresent<BaseGankView>() {

    override fun loadData() {
        IBseView.get()?.showProgress()
        RetrofitHelp.instance.retrofit.create(Api::class.java).suggestData.enqueue(object : Callback<SuggestBeanResult> {
            override fun onFailure(call: Call<SuggestBeanResult>?, t: Throwable?) {
                Log.e("test", "fail")

            }

            override fun onResponse(call: Call<SuggestBeanResult>?, response: Response<SuggestBeanResult>?) {
                IBseView.get()?.loadSuggestData(response?.body()?.suggestBeanList!!)
            }
        })
    }
}