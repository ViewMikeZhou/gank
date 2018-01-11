package com.zhou.customview; /**
 * Created by zhou on 2017/11/20.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class TestAspectActivity extends AppCompatActivity {
    Button bt;
    int btWidht;
    int btHeight;
    int btX;
    int btY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstantceState) {

        super.onCreate(savedInstantceState);
        setContentView(R.layout.activity_main);
        String test = test("10");
        Log.e("TAG", test);


     /*   bt = findViewById(R.id.bt);

        final ViewTreeObserver viewTreeObserver = bt.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                bt.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                *//**
         * 直接是无法获取view宽高(0,0),
         *//*
                btWidht = bt.getWidth();
                btHeight = bt.getHeight();
                bt = findViewById(R.id.bt);
                btX = (int) bt.getX();
                btY = (int) bt.getY();

                Log.e("test", "width :" + btWidht);
            }
        });

        final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bt.getLayoutParams();

        float v = DpUtilKt.dp2pxF(bt, this, 100f);
        final ValueAnimator animator = ObjectAnimator.ofInt((int) v, 500);*/

      /*  bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.animate().translationYBy(-btY - btHeight).alpha(0.5f).setDuration(3000).setInterpolator(new LinearInterpolator()).start();
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int animatedValue = (int) animation.getAnimatedValue();
                        Log.e("test", "animateValue :" + animatedValue);

                        layoutParams.width = (int) animation.getAnimatedValue();
                        //    Log.e("test", "layoutP啊然而-->" + layoutParams.width + ",button-width -->" + btWidht);
                        bt.setLayoutParams(layoutParams);
                    }
                });
                //  animator.setIntValues(layoutParams.width, 1000);
                animator.setDuration(2000);
                animator.start();
            }
        });*/


        //  TestJikPack.test();

    }

    public void testInvoid() {

        Log.e("test", "testInvoid 是否被掉用");
    }


    @NetWork(false)
    public String test(String string) {
        Log.e("TAG", "会不会打印????");
        return string;
    }


}