package com.zhou.gank

import android.app.Application
import com.chad.library.adapter.base.App.App
import com.meiyou.skinlib.AndroidSkin

/**
 * Created by zhou on 2017/11/22.
 */
class AppMe : App() {
    override fun onCreate() {
        super.onCreate()
        AndroidSkin.getInstance().init(App.getInstance() as Application?)
    }
}