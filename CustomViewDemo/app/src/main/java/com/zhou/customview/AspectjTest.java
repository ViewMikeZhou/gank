package com.zhou.customview;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Method;

/**
 * Created by zhou on 2017/11/20.
 */
@Aspect
public class AspectjTest {
    private String TAG = "TAG ";
    private static final String POINT_METHOD = "execution(* com.zhou.customview.TestAspectActivity.test(..))";
    private static final String POINT_CALLMETHOD = "call(* com.zhou.customview.TestAspectActivity.test(..))";

    @Pointcut(POINT_METHOD)
    public void methodAnnotated() {
    }

    @Pointcut(POINT_CALLMETHOD)
    public void methodCallAnnotated() {
    }


    @Around("methodAnnotated()")
    public Object aronudWeaverPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        /**
         *  String o = (String) joinPoint.getArgs()[0];           //获取方法的参数
            TestAspectActivity activity = (TestAspectActivity) joinPoint.getTarget();      //获取调用实例
            activity.testInvoid();
         */

        Class<?> aClass = joinPoint.getTarget().getClass();
       /* Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            Log.e(TAG,method.getName());
        }*/
        Method test = aClass.getMethod("test", String.class);
        NetWork annotation = test.getAnnotation(NetWork.class);
        boolean value = annotation.value();
        if (value){
            Object proceed = joinPoint.proceed();   // 此方法为切点的执行
            return proceed ;
        }

        String result = "-10";
        return result;//替换原方法的返回值
    }

    @Before("methodCallAnnotated()")
    public void beforecall(JoinPoint joinPoint) {
        //Log.e(TAG, "beforecall");
    }
}
