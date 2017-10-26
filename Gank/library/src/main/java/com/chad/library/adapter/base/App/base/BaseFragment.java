package com.chad.library.adapter.base.App.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/29.
 */

public abstract class BaseFragment extends Fragment {
    protected String TAG;
    protected Activity activity;
    private View mView;
    private Unbinder mBind;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        TAG = this.getClass().getSimpleName();
        this.activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(initLayout(), null);
            mBind = ButterKnife.bind(this, mView);
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = mView;
        }
        init(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mBind.unbind();
    }
    public void replease(){}

    protected void startActivity(){

    }

    protected abstract int initLayout();

    protected abstract void init(Bundle savedInstanceState);


}
