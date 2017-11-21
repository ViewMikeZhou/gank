package com.zhou.customview;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by zhou on 2017/11/20.
 */
@Aspect
public class AspectjTest {
    private String TAG = "TAG ";
    private static final String POINT_METHOD = "execution(* com.zhou.customview.TestAspectActivity.test(..))";
    private static final String POINT_CALLMETHOD = "call(* com.zhou.customview.TestAspectActivity.test(..))";
    @Pointcut(POINT_METHOD)
    public void methodAnnotated(){}
    @Pointcut(POINT_CALLMETHOD)
    public void methodCallAnnotated(){}
    @Around("methodAnnotated()")
    public Object aronudWeaverPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        joinPoint.proceed();
    //    String o = (String) joinPoint.getArgs()[0];           //获取方法的参数
   //    TestAspectActivity activity = (TestAspectActivity) joinPoint.getTarget();      //获取调用实例
   //    activity.testInvoid();

        Log.e(TAG,"----------------------------->aroundWeaverPoint");
        String result = "----------------------------->aroundWeaverPoint";
        return  result;//替换原方法的返回值
    }
    @Before("methodCallAnnotated()")
    public void beforecall(JoinPoint joinPoint){
        Log.e(TAG,"beforecall");
    }
}
