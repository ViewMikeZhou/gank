package com.zhou.gank

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.chad.library.adapter.base.App.App
import com.meiyou.skinlib.AndroidSkin

/**
 * Created by zhou on 2017/11/22.
 */
class AppMe : App() {
    override fun onCreate() {
        super.onCreate()
        AndroidSkin.getInstance().init(App.getInstance() as Application?)
        registerActivityLifecycleCallbacks(object:ActivityLifecycleCallbacks{
            override fun onActivityPaused(activity: Activity?) {

            }

            override fun onActivityResumed(activity: Activity?) {

            }

            override fun onActivityStarted(activity: Activity?) {
                var toString = activity.toString()
                Log.e("tag",toString)
            }

            override fun onActivityDestroyed(activity: Activity?) {
                var toString = activity.toString()
                Log.e("tag",toString)
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

            }

            override fun onActivityStopped(activity: Activity?) {

            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {

            }
        })
    }
}