package com.zhou.gank.retrofit

import com.chad.library.adapter.base.App.util.NetworkUtil
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.zhou.gank.AppMe
import com.zhou.gank.BuildConfig
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


/**
 * Created by zhou on 2017/10/26.
 */
class RetrofitHelp {
    private val DEFAULT_TIMEOUT: Long = 10
    private val BASE_URL: String = "http://gank.io/"
    var retrofit: Retrofit = initRetrofit()

    private object Holder {
        val INSTANCE = RetrofitHelp()
    }

    companion object {
        val instance: RetrofitHelp by lazy { Holder.INSTANCE }
        //  val instance :RetrofitHelp by lazy { RetrofitHelp() }
    }

    private fun initRetrofit(): Retrofit {

        val interceptor = HttpLoggingInterceptor()
        var cache = Cache(File(AppMe.instance?.cacheDir, "httpcache"), 1024 * 1024 * 3)
        if (BuildConfig.DEBUG)
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        else
            interceptor.level = HttpLoggingInterceptor.Level.NONE

        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache)
                .retryOnConnectionFailure(true)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build()
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    private class CacheIntercepter : Interceptor {
        override fun intercept(chain: Interceptor.Chain?): Response? {
            val cacheBuilder = CacheControl.Builder()
            cacheBuilder.maxAge(30, TimeUnit.SECONDS)  //设置有网缓存时间
            cacheBuilder.maxStale(1, TimeUnit.DAYS)     //无网络缓存时间
            val cacheControl = cacheBuilder.build()
            var request = chain?.request()
            if (!NetworkUtil.isNetworkConnected(AppMe.instance)) {
                request = request?.newBuilder()
                        ?.cacheControl(cacheControl)
                        ?.build()
            }
            val originalResponse = chain?.proceed(request)
            if (NetworkUtil.isNetworkConnected(AppMe.instance)) {
                val maxAge = 30 //有网缓存
                return originalResponse?.newBuilder()
                        ?.removeHeader("Pragma")
                        ?.header("Cache-Control", "public ,max-age=" + maxAge)
                        ?.build()
            } else {
                val maxStale = 60 * 60 * 24 // 1天
                return originalResponse?.newBuilder()
                        ?.removeHeader("Pragma")
                        ?.header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        ?.build()
            }

        }

    }

}