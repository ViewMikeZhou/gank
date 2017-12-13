package com.zhou.gank.view;

import android.util.Log;

import com.chad.library.adapter.base.baseAdapter.loadmore.LoadMoreView;
import com.zhou.gank.R;

/**
 * Created by zhou on 2017/12/5.
 */

public class CustomLoadMoreView extends LoadMoreView {
    @Override
    public int getLayoutId() {
        Log.e("test","getLayoutId");
        return R.layout.load_more_view;
    }

    @Override
    protected int getLoadingViewId() {
        Log.e("test","getLoadingViewId");

        return   R.id.loadmore;
    }

    @Override
    protected int getLoadFailViewId() {
        Log.e("test","getLoadFailViewId");
        return  R.id.load_more_load_fail_view;
    }

    @Override
    protected int getLoadEndViewId() {
        Log.e("test","getLoadEndViewId");
        return  R.id.load_more_load_end_view;
    }


}
