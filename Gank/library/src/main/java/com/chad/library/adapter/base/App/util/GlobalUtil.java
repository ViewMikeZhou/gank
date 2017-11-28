package com.chad.library.adapter.base.App.util;


import android.content.Context;
import android.view.WindowManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GlobalUtil {

    //dp装px
    public static int dip2px(float dpValue,Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    //px 转dp
    public static int px2dp(float pxValue,Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static Long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static String getCurrentTime(long current) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(current);
        return formatter.format(curDate);
    }

    public static  String timeFormat(int hourOfDay,int minute){
        String hour ="";
        String minut="";
        if (hourOfDay < 10){
            hour  = "0"+hourOfDay;
        }else{
            hour = hourOfDay+"";
        }
        if (minute < 10){
            minut = "0"+minute;
        }else{
            minut = minute+"";
        }
        return hour+":"+minut;
    }

    public static int getScreenWidth(Context context){
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;

    }


}
