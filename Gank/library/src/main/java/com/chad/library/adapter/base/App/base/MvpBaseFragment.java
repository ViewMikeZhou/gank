package com.chad.library.adapter.base.App.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by zhou on 2017/9/29.
 */

public abstract class MvpBaseFragment<V,T extends BasePresent> extends Fragment {
    protected T presenter;
    protected boolean bIsViewCreated;
    protected boolean bIsDataLoaded;
    private View mView;

   // protected LazyActitvity mActitvity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
     //   mActitvity = (LazyActitvity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {      //不重新初始化view
            mView = inflater.inflate(getLayoutResId(), container, false);
            presenter =creatPrester();
            presenter.attachView((V)this);
            initView(mView);
        }
        bIsViewCreated = true;
        if (getUserVisibleHint() && !bIsDataLoaded) {
            loadData();
            bIsDataLoaded = true;
        }
        return mView;
    }

    protected abstract T creatPrester();


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        bIsViewCreated = false;
        bIsDataLoaded = false;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && bIsViewCreated && !bIsDataLoaded) {
            bIsDataLoaded = true;
            loadData();
        } else if (!isVisibleToUser && bIsDataLoaded) {
            userUnVisible();
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detachView();
    }

    /**
     * 不可见时调用
     */
    protected abstract void userUnVisible();


    /**
     * 布局文件
     */
    protected abstract int getLayoutResId();

    /**
     * 初始化view
     */
    protected abstract void initView(View view);

    /**
     * 加载数据
     */
    protected abstract void loadData();
}

