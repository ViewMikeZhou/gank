package com.zhou.customview

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**抛物线自定义view第三篇,绘制文本, 测量文本,设置文本的的一些属性 ->字体,下滑线,删除线, 加粗....
 * Created by zhou on 2017/11/9.
 */
class CustomView5 : View {
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
        resultHight =400f
    }

    override fun onDraw(canvas: Canvas?) {
      // var bm=   BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher_round)
     /*   var bm = BitmapFactory.decodeResource(resources, R.mipmap.window)
        var centerY =bm.height *0.5f
        var centerX =bm.width*0.5f
        canvas?.save()
       // canvas?.clipRect(Rect(100,0,100+bm.height,bm.height))
        canvas?.rotate(45f,100+centerX,100+centerY)
       // canvas?.scale(2.3f,2.3f,centerX,centerY)
        canvas?.skew(0f, 0.5f);
        canvas?.drawBitmap(bm,100f,100f,paint)
        canvas?.restore()
        canvas?.save();*/

        var bm = BitmapFactory.decodeResource(resources, R.mipmap.window)

        var camera = Camera()

        canvas?.save()
        camera.save()
        camera.rotateX(30f)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas?.drawBitmap(bm,100f,100f,paint)

        canvas?.restore()

    }
}