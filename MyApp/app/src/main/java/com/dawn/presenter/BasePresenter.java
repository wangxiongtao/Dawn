package com.dawn.presenter;

import com.dawn.mvp.IPresenter;
import com.dawn.mvp.IView;
import com.http_service.HttpCallBack;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public abstract class BasePresenter implements IPresenter ,HttpCallBack {
    private WeakReference<IView> viewRef;

    public BasePresenter(IView view){
        viewRef=new WeakReference<>(view);
    }

    @Override
    public IView getView() {
        if(viewRef==null){
            return null;
        }
        return viewRef.get();
    }

    @Override
    public void onHttpStart(int tag) {
        if(getView()!=null){
            getView().showLoading();
        }
    }

    @Override
    public void onHttpFail(int tag) {

    }

    @Override
    public void onDestory() {
       if(viewRef!=null){
           viewRef.clear();
           viewRef=null;
       }
    }
}
