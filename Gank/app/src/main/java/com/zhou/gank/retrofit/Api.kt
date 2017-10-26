package com.zhou.gank.retrofit

import com.zhou.gank.gank.m.AndroidBeanResult
import com.zhou.gank.gank.m.IosBeanResult
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by zhou on 2017/10/26.
 */
interface Api {
    @get:GET("api/data/Android/10/1")
    val androidData: Call<AndroidBeanResult>

    @get:GET("api/data/iOS/10/1")
    val iosData : Call<IosBeanResult>

}