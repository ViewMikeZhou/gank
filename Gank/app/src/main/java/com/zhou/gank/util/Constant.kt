package com.zhou.gank.util

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by zhou on 2017/10/25.
 */

val GANK_TYPE = "gankType"

fun Context.getS():SharedPreferences = this.getSharedPreferences("test1",Context.MODE_PRIVATE)