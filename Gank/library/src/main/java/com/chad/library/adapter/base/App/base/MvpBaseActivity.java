package com.chad.library.adapter.base.App.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zhou on 2017/9/29.
 */

public abstract class MvpBaseActivity<V,T extends BasePresent<V>> extends AppCompatActivity {
    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        presenter =creatPresenter();
        presenter.attachView((V) this);
        initData();

    }

    protected abstract int initLayout();
    protected abstract T creatPresenter();
    protected abstract void initData();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
