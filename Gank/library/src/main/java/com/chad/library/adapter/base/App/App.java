package com.chad.library.adapter.base.App;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Administrator on 2017/8/22.
 */

public class App extends Application{
    private static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance =this;
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
      //  DaoUtils.init(this);
        LeakCanary.install(this);
        Stetho.initializeWithDefaults(this);
    }

    public static Context getInstance() {
        return instance;
    }
}
