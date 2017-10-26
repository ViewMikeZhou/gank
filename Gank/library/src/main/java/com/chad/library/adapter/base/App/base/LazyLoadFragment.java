package com.chad.library.adapter.base.App.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * �ӳټ���Fragment
 * Created by flying on 2017/3/2.
 */

public abstract class LazyLoadFragment extends BaseFragment {
    protected boolean bIsViewCreated;
    protected boolean bIsDataLoaded;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {      //�����³�ʼ��view
            mView = inflater.inflate(getLayoutResId(), container, false);
            initView(mView);
        }
        bIsViewCreated = true;
        if (getUserVisibleHint() && !bIsDataLoaded) {
            loadData();
            bIsDataLoaded = true;
        }
        return mView;
    }


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


    /**
     * ���ɼ�ʱ����
     */
    protected abstract void userUnVisible();


    /**
     * �����ļ�
     */
    protected abstract int getLayoutResId();

    /**
     * ��ʼ��view
     */
    protected abstract void initView(View view);

    /**
     * ��������
     */
    protected abstract void loadData();

}
