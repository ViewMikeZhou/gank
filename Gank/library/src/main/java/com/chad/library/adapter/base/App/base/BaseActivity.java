package com.chad.library.adapter.base.App.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/29.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mBind;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        mBind = ButterKnife.bind(this);
        init(savedInstanceState);
    }
    public abstract int initLayout();
    protected abstract void init(Bundle savedInstanceState);


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }

}
