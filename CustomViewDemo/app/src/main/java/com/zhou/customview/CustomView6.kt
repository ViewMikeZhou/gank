package com.zhou.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.EditText

/**绘制顺序:ondraw(),dispatchDraw,onDrawForeground;
 * 在draw()方法中会一次调用绘制方法->ondraw(),dispatchDraw,onDrawForeground;
 *
 * Created by zhou on 2017/11/14.
 */
class CustomView6 : EditText {
    var paint :Paint? = null
    var isDraw:Boolean = false
    private var progress:Float = 0.0f
    constructor(context: Context):this(context,null)
    constructor(context:Context,attributeSet: AttributeSet?):this(context,attributeSet,0)

    constructor(context: Context, attrs: AttributeSet?, defstyle: Int) : super(context, attrs, defstyle) {
        initPaint()
    }

    private fun initPaint() {
        paint = Paint()
        paint?.textSize = 20f
        paint?.style = Paint.Style.FILL
    }

    override fun draw(canvas: Canvas?) {
        canvas?.drawColor(Color.parseColor("#66BB6A"))
        super.draw(canvas)
    }

    public fun setProgress(progress :Float) {
        this.progress = progress
        isDraw = true
        invalidate()
    }

    fun setColor(color:Int){
        paint?.color = color
        invalidate()
    }


    override fun onDraw(canvas: Canvas?) {
        /**
         *  day6 验证属性动画 progress
         */
       /* canvas?.drawArc(RectF(100f,100f,200f,200f),0f, progress , false, paint)
        canvas?.drawText("$progress",120f,150f,paint)*/

        /**
         * day7 验证 Evaluator ->自定义Evaluator
         */
      //canvas?.drawCircle(100f,100f,100f,paint)


    }


    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
    }

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)



    }


}