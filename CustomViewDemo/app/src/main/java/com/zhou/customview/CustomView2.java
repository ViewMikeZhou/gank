package com.zhou.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**抛物线自定义view 第一篇
 * Created by zhou on 2017/11/8.
 */

public class CustomView2 extends View {

    private Paint mPaint;

    public CustomView2(Context context) {
        this(context,null);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);

/*
        mPaint2 = new Paint();
        mPaint2.setColor(Color.RED);

        mPaint3 = new Paint();
        mPaint3.setColor(Color.BLACK);*/
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                float rawX = event.getRawX();
                float rawY = event.getRawY();
                Log.e("test","x ->"+x+",y ->"+y+",Rawx ->"+rawX+",rawY ->"+rawY);
                mPaint.setColor(Color.YELLOW);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setTextSize(40);
        canvas.drawText("first",110,50,mPaint);

        canvas.drawArc(110, 110, 500, 500, 90, 180, true, mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawArc(110, 110, 510, 510, 0, 90, true, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(110, 110, 510, 490, -90, 90, true, mPaint);

        mPaint.setColor(Color.RED);

        Rect r = new Rect();
        mPaint.getTextBounds(":代表人数",0,5,r);
        canvas.drawRect(new Rect(110,530,140,560),mPaint);


        float y = r.height();
        Log.d("CustomView2", "y:" + y);
        canvas.drawText(":代表人数",160,560,mPaint);
      //  canvas.drawArc(110, 110, 510, 510, -90, 90, true, mPaint3);
      //  canvas.drawLine(50,50,200,200,mPaint);
    }

    public void testDraw(){

    }

}
