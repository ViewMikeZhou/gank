package com.chad.library.adapter.base.App.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by zhou on 2017/9/29.
 */

public abstract class BasePresent<V> {

    protected Reference<V> IBseView;
    public void attachView(V view){
        IBseView = new WeakReference<V>(view);
    }

    public V getView(){
        return IBseView.get();
    }

    public boolean isViewAttached(){
        return  IBseView != null && IBseView.get() != null;
    }

    public void detachView(){
        IBseView.clear();
    }

    public abstract void loadData();

    public  abstract  void loadMore();

}
