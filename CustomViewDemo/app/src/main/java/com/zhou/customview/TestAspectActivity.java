package com.zhou.customview; /**
 * Created by zhou on 2017/11/20.
 */

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

import com.zhou.testjitpack_lib.TestJikPack;

public class TestAspectActivity extends AppCompatActivity {
    Button bt;
    int btWidht;
    int btHeight;
    int btX;
    int btY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstantceState) {
        Log.e("TAG", "oncreat---->1");
        super.onCreate(savedInstantceState);
        setContentView(R.layout.activity_main);
        String test = test("test");
        Log.e("TAG", "改变后的结果:" + test);
        Log.e("TAG", "oncreat---->2");



        bt = findViewById(R.id.bt);

        final ViewTreeObserver viewTreeObserver = bt.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                bt.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                /**
                 * 直接是无法获取view宽高(0,0),
                 */
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
        final ValueAnimator animator = ObjectAnimator.ofInt((int) v, 500);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.animate().translationYBy(-btY - btHeight).alpha(0.5f).setDuration(3000).setInterpolator(new LinearInterpolator()).start();
/*
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
                animator.start();*/
            }
        });


        TestJikPack.test();

    }


    private String test(String string) {
        Log.e("TAG", "test---->1");
        for (int i = 0; i < 1000; i++) {
            System.out.print(i);
        }
        Log.e("TAG", "test---->2");
        return string;
    }

    public void testInvoid() {

        Log.e("test", "testInvoid 是否被掉用");
    }

}