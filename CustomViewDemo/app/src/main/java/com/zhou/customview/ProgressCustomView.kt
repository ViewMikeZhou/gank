package com.zhou.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import org.jetbrains.anko.displayMetrics

/**模仿审核进度
 * Created by zhou on 2017/11/16.
 */
class ProgressCustomView:View {
    val paint: Paint by lazy { Paint() }


    val  lPaint :Paint by lazy { Paint() }


    val lineW: Float = 100f      // 间隔的线长

    val title:ArrayList<String> by lazy { arrayListOf("提交申请","审核","退款","完成") }

    var titleRects :ArrayList<Rect> = arrayListOf()             // 存储没个titleRect


    var bmComplete :Bitmap = BitmapFactory.decodeResource(resources,R.mipmap.audit_complete)

    var bmUnComplete: Bitmap = BitmapFactory.decodeResource(resources,R.mipmap.audit_uncomplete)

    constructor(context: Context):this(context,null)
    constructor(context: Context, attributeSet: AttributeSet?):this(context,attributeSet,0)

    constructor(context: Context, attrs: AttributeSet?, defstyle: Int) : super(context, attrs, defstyle) {
        initPaint()
    }

    private fun initPaint() {
        paint.textSize = dp2pxF(context,14f)
        lPaint.color =Color.GREEN
        lPaint.strokeWidth = 5f


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        var mode = MeasureSpec.getMode(widthMeasureSpec)
        var resultW =0
        if (mode == MeasureSpec.EXACTLY){
            resultW = MeasureSpec.getSize(widthMeasureSpec)
        }else{
            resultW = measureTextData().toInt()
        }

        setMeasuredDimension(widthMeasureSpec, resultW)
    }

    private fun measureTextData() :Float{

        var screenW = context.displayMetrics.widthPixels
        //线的总长度
        var totalLineW = lineW * (title.size-1)
        // 图片的总长度
        var totalbmW = bmComplete.width * (title.size -1)


        title.forEachIndexed { index, s ->
            var rect  = Rect()

            paint.getTextBounds(s,0,s.length,rect)
            titleRects.add(index,rect)
        }


        var tW = titleRects[0].width()
        var tH = titleRects[0].height()
        Log.e("test","tW --> $tW ,tH --> $tH,bmW --> ${bmComplete.width}")


        return totalLineW + totalbmW

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var bmW = bmUnComplete.width


        for(i in 0 until title.size){

           var  bmLeft = 10f + (i*(bmW+lineW+10))

           var lineStartX = bmLeft + bmW +10f


           var titleX = bmLeft-10f

            var titleY =  bmComplete.height + 10f +30f


            if (i == title.size -1){
                canvas?.drawBitmap(bmComplete,bmLeft,10f,paint)

            }else{
                canvas?.drawBitmap(bmUnComplete,bmLeft,10f,paint)

                canvas?.drawLine(lineStartX,(10f+bmUnComplete.height/2),lineStartX+lineW-10,(10f+bmUnComplete.height/2),lPaint)

                canvas?.drawText(title[i],titleX,titleY,paint)

            }

        }

    }
}