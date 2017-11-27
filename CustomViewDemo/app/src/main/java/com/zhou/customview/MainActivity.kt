package com.zhou.customview

import android.animation.ObjectAnimator
import android.graphics.Camera
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find
import java.lang.ref.WeakReference


class MainActivity : AppCompatActivity() {


    var custome1: CostomView1? = null

    /**
     *  class MyHandler 为静态内部类 , 若希望不是静态要 加上 inner;
     *  防止内存溢出正确的书写方式->防止内存溢出;
     */
    class MyHandler : Handler {
        var weekAc: WeakReference<MainActivity>? = null

        constructor(context: MainActivity) {
            weekAc = WeakReference(context)
        }

        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            //weekAc?.get()?.custome1.
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var a:Int = 0x03

        var c = a and 0x01

        Log.e("test","c --> $c")

       var p = bt.layoutParams
        var ofInt = ObjectAnimator.ofInt(bt?.width!!, 1000)
        Camera

        /*   var custom1 = findViewById(R.id.custom1) as CostomView1
           var handler = MyHandler(this);
           custom1.animate().setListener(object :Animator.AnimatorListener{
               override fun onAnimationRepeat(animation: Animator?) {
               }
               override fun onAnimationEnd(animation: Animator?) {
                   CGFloat w = self.frame.size.width / titleData.count;
                   CGFloat h = self.frame.size.height;
                   UIButton btTitle =UIButton alloc]initWithFrame(i*w,0,w,h);
                   btTile.label.title = dataList[i]
                   [self addsubViews btTitle]
               }

               override fun onAnimationCancel(animation: Animator?) {
               }

               override fun onAnimationStart(animation: Animator?) {
               }
           })
           handler.postDelayed({
               //ViewPropertyAnimation动画
               // custom1.animate().translationX(50f).setDuration(1000).setStartDelay(1000)
               //属性动画
               ObjectAnimator.ofFloat(custom1, "translationX", 50f).setDuration(2000).start()
           }, 2000)
   */

        var customView6 = find<CustomView6>(R.id.custom_view6)
        // 属性动画需要对应的view有set 方法,如下 customView6 具备setProgress方法;
        // ObjectAnimator.ofFloat(customView6,"progress",360f).setDuration(3000).start()
        //  ObjectAnimator.ofInt(customView6,"color",0xffff0000,0xff00ff00)
        /**
         * Evaluator 使用; ofAgb 也可以到这个效果不过sdk要求过高
         * 自定义 Evaluator -->MyEvaluator
         *
         */

          val animator = ObjectAnimator.ofInt(customView6, "color", -0xff0000, -0x0000ff)
          animator.setEvaluator(MyEvaluator())
          animator.duration = 2000
          animator.start()

          customView6.animate().scaleX(0f).scaleX(1f).translationXBy(100f).setDuration(2000).start()


    }


}


