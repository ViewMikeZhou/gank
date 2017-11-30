package com.zhou.gank

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.facebook.stetho.Stetho
import com.meiyou.skinlib.AndroidSkin
import com.squareup.leakcanary.LeakCanary

/**
 * Created by zhou on 2017/11/22.
 */
class AppMe : Application() {


    companion object {
       var instance: AppMe by notNullSingleValue()

    }

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        instance = this ;
        //  DaoUtils.init(this);
        LeakCanary.install(this);
        Stetho.initializeWithDefaults(this);
        //添加皮肤更换库

        AndroidSkin.getInstance().init(this as Application?)


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