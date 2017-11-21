package com.zhou.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

/**抛物线自定义view 第一篇
 * Created by zhou on 2017/11/8.
 */
class CostomView1 : View {
    private val mPaint: Paint by lazy { Paint() }

   /* private val mPaint2: Paint? = null
    private val mPaint3: Paint? = null*/


    constructor(context: Context) : this(context,null)

    constructor(context: Context, attrs: AttributeSet?): this(context,attrs,0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr){
        init()
    }


    private fun init() {
      //  mPaint = Paint()
        mPaint.color = Color.BLUE
        /*
        mPaint2 = new Paint();
        mPaint2.setColor(Color.RED);

        mPaint3 = new Paint();
        mPaint3.setColor(Color.BLACK);*/
    }


    fun setProgress(progress: Float){

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                val x = event.x
                val y = event.y
                val rawX = event.rawX
                val rawY = event.rawY
                Log.e("test", "x ->$x,y ->$y,Rawx ->$rawX,rawY ->$rawY")
                mPaint.color = Color.YELLOW
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        return super.onTouchEvent(event)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        mPaint.textSize = 40f
        canvas.drawText("first", 110f, 50f, mPaint)

        canvas.drawArc(110f, 110f, 500f, 500f, 90f, 180f, true, mPaint)
        mPaint.color = Color.RED
        canvas.drawArc(110f, 110f, 510f, 510f, 0f, 90f, true, mPaint)
        mPaint.color = Color.BLACK
        canvas.drawArc(110f, 110f, 510f, 490f, -90f, 90f, true, mPaint)

        mPaint.color = Color.RED

        val r = Rect()
        mPaint.getTextBounds(":代表人数", 0, 5, r)
        canvas.drawRect(Rect(110, 530, 140, 560), mPaint)


        val y = r.height().toFloat()
        Log.d("CustomView2", "y:" + y)
        canvas.drawText(":代表人数", 160f, 560f, mPaint)
        //  canvas.drawArc(110, 110, 510, 510, -90, 90, true, mPaint3);
        //  canvas.drawLine(50,50,200,200,mPaint);
    }



}