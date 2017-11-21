package com.zhou.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**抛物线自定义view第三篇,绘制文本, 测量文本,设置文本的的一些属性 ->字体,下滑线,删除线, 加粗....
 * Created by zhou on 2017/11/9.
 */
class CustomView4 : View {
    val paint: Paint by lazy { Paint() }
    var bm = BitmapFactory.decodeResource(resources, R.mipmap.window)
    var resultHight = 0f


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defstyle: Int) : super(context, attrs, defstyle) {
        initThing()
    }

    private fun initThing() {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
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

        resultHight =100f
    }

    override fun onDraw(canvas: Canvas?) {
       /* var textPaint = TextPaint()     // TextPaint为Paint的子类;
        textPaint.textSize = 50f
        var text = "这是一段文字\n我不会到会不会换行\n如果换行了这是第三行"
        var staic = StaticLayout(text,textPaint,1000, Layout.Alignment.ALIGN_NORMAL,1f,0f,true)
        staic.draw(canvas)*/

        var rect = Rect()
        var p = Paint()
        p.typeface = Typeface.DEFAULT
        p.textSize = 40f
        var str ="三个月内你胖了"
        p.getTextBounds(str,0,str.length,rect)
        Log.e("test","top -> ${rect.top},bottom ->${rect.bottom},height ->${rect.height()}")
        canvas?.drawText(str,0,str.length,0f,rect.height().toFloat(),p)


        var str1 = "45"
        var rect1 = Rect()
        p.typeface = Typeface.DEFAULT_BOLD
        p.textSize = 50f
        p.isStrikeThruText = true // 添加删除线
        p.color = Color.RED
        p.getTextBounds(str1,0,str1.length,rect1)
        canvas?.drawText(str1,0,str1.length,rect.width().toFloat(),rect.height().toFloat()+2,p)

        p.reset()
        var str2 = "公斤"
        p.typeface = Typeface.DEFAULT
        p.textSize = 40f

        canvas?.drawText(str2,0,str2.length,rect.width().toFloat()+rect1.width().toFloat(),rect.height().toFloat(),p)

    }
}