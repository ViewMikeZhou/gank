package com.zhou.gank

import android.app.Activity
import android.os.Bundle
import android.os.Handler

/**
 * Created by zhou on 2017/11/22.
 */
class SkinTranActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skin)
        var handle = Handler()
        handle.postDelayed(object :Runnable{
            override fun run() {
               finish()
            }

        },2000)
    }
}