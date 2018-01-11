package com.zhou.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**抛物线自定义view第二篇 Paint 的api 和颜色  setColor  sharde xfermode
 * Created by zhou on 2017/11/9.
 */
class CustomView3 : View {
    val paint: Paint by lazy { Paint() }
    var bm = BitmapFactory.decodeResource(resources, R.mipmap.window)
    var resultHight = 0f


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defstyle: Int) : super(context, attrs, defstyle) {
        initThing()
    }

    private fun initThing() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        paint.isAntiAlias = true            // 设置抗锯齿
        paint.style = Paint.Style.STROKE    //设置不填充
        paint.textSize = 20f
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var hight = MeasureSpec.getSize(heightMeasureSpec)

        //控件完全显示所需高度!



        /**
         *  MeasureSpec.EXACTLY 相当于 将高固定为 100dp 或设置为 matchParter
         */
        if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY) {
            resultHight = hight.toFloat()

        } else {
        /**
         * 其他模式相当于warpcontent 所有需要计算处 当前view中所占的高度!
         */

        }
        setMeasuredDimension(widthMeasureSpec, resultHight.toInt())
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        resultHight = bm.height + 50f
    }

    override fun onDraw(canvas: Canvas?) {

        /* var shader = LinearGradient(100f,100f,200f, 200f,Color.parseColor("#E91E63"),
                 Color.parseColor("#2196F3"), Shader.TileMode.CLAMP)
         paint.shader = shader
         canvas?.drawCircle(300f,200f,200f,paint)*/
        //   var save = canvas?.saveLayer(null,null,Canvas.ALL_SAVE_FLAG)


        var xfm = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)

        // paint.setShadowLayer(10f,0f,0f,Color.RED)


        //   canvas?.drawBitmap(bm, 100f, 50f, paint)

        canvas?.drawBitmap(bm, null, Rect(0, 0, 200, 200), paint)

        paint.xfermode = xfm
        /*   var bmShader = BitmapShader(bm, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
           paint.shader = bmShader*/

        canvas?.drawBitmap(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher), 100f, 50f, paint)

        paint.xfermode = null

        //    canvas?.restoreToCount(save!!)

        //  canvas?.drawCircle(300f, 200f, 150f,paint )


    }
}