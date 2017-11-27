package com.zhou.customview; /**
 * Created by zhou on 2017/11/20.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhou.testjitpack_lib.TestJikPack;

public class TestAspectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstantceState) {
        Log.e("TAG","oncreat---->1");
        super.onCreate(savedInstantceState);
        setContentView(R.layout.activity_main);
        String test = test("test");
        Log.e("TAG","改变后的结果:"+test);
        Log.e("TAG","oncreat---->2");




        TestJikPack.test();

    }

    private String test(String string) {
        Log.e("TAG","test---->1");
        for (int i = 0 ; i < 1000 ; i ++) {
            System.out.print(i);
        }
        Log.e("TAG","test---->2");
        return string;
    }

    public    void testInvoid(){

        Log.e("test","testInvoid 是否被掉用");
    }

}