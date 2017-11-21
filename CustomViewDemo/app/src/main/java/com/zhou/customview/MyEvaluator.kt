package com.zhou.customview

import android.animation.TypeEvaluator

/**
 * Created by zhou on 2017/11/16.
 */
class MyEvaluator : TypeEvaluator<Int> {
    override fun evaluate(fraction: Float, startValue: Int?, endValue: Int?): Int {
      //  Log.e("test","fraction --> $fraction,startValue -->$startValue ,endValue --> $endValue")

       var endValue= (fraction * endValue!!).toInt()
        return endValue
    }
}