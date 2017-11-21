package com.zhou.customview.TestDemo

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View


/**
 * Created by zhou on 2017/11/10.
 */
class AbilityMapView : View {
    var resultHight = 0f
    var data: AbilityBean? = null           //元数据
    var n: Int = 0                        //边的个数
    var r: Float? = 0.0f                   //最外圈圆的半径
    var intervalCount: Int = 0              //将半径分为几部分
    var angle: Float = 0.0f                //相邻2条线的角度
    val linePaint: Paint by lazy { Paint() }          //划线的笔
    val textPaint: Paint by lazy { Paint() }        //画文字的笔
    var viewWidth: Int = 0                      //控件的宽度
    var viewHeigth: Int = 0                      //文件的高度
    var pointsArray: ArrayList<ArrayList<PointF>>? = null   //存储多边形顶点的数组;


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initSize()
        initPoint()
        initPaint()
    }


    private fun initSize() {
        //七条边
        n = 7
        r = dp2pxF(context, 50f)  //半径暂时设为100dp
        intervalCount = 4   //有四层
        //一周是2π,这里用π，因为进制的问题，不能用360度,画出来会有问题
        angle = (2 * Math.PI / n).toFloat()
        //拿到屏幕的宽高，单位是像素
        val screenWidth = resources.displayMetrics.widthPixels
        //控件设置为正方向
        viewWidth = screenWidth
        viewHeigth = screenWidth
    }


    private fun initPoint() {
        pointsArray = arrayListOf()

        for (i in 0 until intervalCount) {
            //每一次都有 pointF的集合
            var point = arrayListOf<PointF>()
            for (j in 0 until n) {
                //每一圈的半径都是按比例减少
                var radius = r!! * ((4 - i) * 1.0f / intervalCount)

                Log.e("test", "radius --> ${radius}")

                //这里减去Math.PI / 2 是为了让多边形逆时针旋转90度，所以后面的所有用到cos,sin的都要减
                x = ((radius * Math.cos(j * angle - Math.PI / 2))).toFloat()
                y = ((radius * Math.sin(j * angle - Math.PI / 2))).toFloat()
                point.add(PointF(x, y))
            }
            pointsArray?.add(point)
        }


    }

    private fun initPaint() {
        linePaint.strokeWidth = dp2pxF(context, 1f)!!
        linePaint.style = Paint.Style.FILL_AND_STROKE
        textPaint.textAlign = Paint.Align.CENTER
        textPaint.color = Color.BLACK
        textPaint.textSize = sp2px(context, 14f)!!
    }

    /*  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
          var hight = MeasureSpec.getSize(heightMeasureSpec)
          //控件完全显示所需高度!

          */
    /**
     *  MeasureSpec.EXACTLY 相当于 将高固定为 100dp 或设置为 matchParter
     *//*
        if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY) {
            resultHight = hight.toFloat()
        } else {
            */
    /**
     * 其他模式相当于warpcontent 所有需要计算处 当前view中所占的高度!
     *//*

        }
        setMeasuredDimension(widthMeasureSpec, resultHight.toInt())
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        resultHight =100f
    }*/



    override fun onDraw(canvas: Canvas?) {
        //将画布移动到屏幕中间
        canvas?.translate(viewWidth / 2.0f, viewHeigth / 2.0f)
        //canvas?.translate(40f,40f)
        drawPolygon(canvas)
        linePaint.color = Color.RED

        var path = Path()
        canvas?.drawRect(Rect(0, 0, 30, 30), linePaint)

        path.moveTo(-20f, 0f)
        path.lineTo(200f, 0f)

        canvas?.drawPath(path, linePaint)

    }

    /**
     * 画图形
     */
    fun drawPolygon(canvas: Canvas?) {
        var path = Path()
        for (i in 0 until intervalCount) {  // i in 0..7  ==> 会包含7
            when (i) {
                0 -> linePaint.color = Color.parseColor("#D4F0F3")
                1 -> linePaint.color = Color.parseColor("#99DCE2")
                2 -> linePaint.color = Color.parseColor("#56C1C7")
                3 -> linePaint.color = Color.parseColor("#278891")
            }

            Log.e("test", "i --> ${i}")
            for (j in 0 until n) {

                var x = pointsArray?.get(i)?.get(j)?.x!!
                var y = pointsArray?.get(i)?.get(j)?.y!!

                if (j == 0) {
                    path.moveTo(x, y)
                } else {
                    path.lineTo(x, y)
                }
            }
            // 闭合path
            path.close()
            canvas?.drawPath(path, linePaint)
            path.reset()
        }
    }


    /**
     *   dp转px
     */
    private fun dp2pxF(context: Context?, dpVaule: Float): Float? {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVaule, context?.resources?.displayMetrics)

    }

    /**
     * sp转px
     */
    private fun sp2px(context: Context?, spVaule: Float): Float? {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVaule, context?.resources?.displayMetrics)
    }


}