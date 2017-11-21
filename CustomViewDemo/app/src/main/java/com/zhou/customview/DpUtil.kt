package com.zhou.customview

import android.content.Context
import android.util.TypedValue
import android.view.View

/**
 * Created by zhou on 2017/11/16.
 */



    /**
     *   dp转px
     */
    public fun View.dp2pxF(context: Context?, dpVaule: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVaule, context?.resources?.displayMetrics)

    }

    /**
     * sp转px
     */
    public  fun View.sp2px(context: Context?, spVaule: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVaule, context?.resources?.displayMetrics)
    }
