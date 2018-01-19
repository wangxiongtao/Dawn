package com.dawn.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * 基类的Fragment 定义了Fragment中的常用方法黄金啊哈哈
 * 布局文件初始化
 * 实现了懒加载
 */

public abstract class BaseFragment extends Fragment {
    private View mRootView;
    private boolean isLoadDataed;//是否已经加载了数据
    private boolean isVisible;//是否对用户可见

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
            initView(mRootView);
            setListener();
            initData();
            lazyLoad();
        } else {
            //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        }


        return mRootView;
    }

    protected abstract int getLayoutId();//加载的布局文件id

    protected abstract void initView(View mRootView);//初始化view

//    protected abstract int getStatusBarColorId();//状态栏沉浸的颜色

    protected abstract void setListener();//添加的各种监听

    protected abstract void initData();//获取数据等逻辑操作


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isVisible = true;
            lazyLoad();
        }
    }

    private void lazyLoad() {
        if (isLoadDataed || !isVisible || mRootView==null) {//如果已经加载了数据或者不可见或者还没有初始化view就不加载数据了
            return;
        }
        onLazyLoad();
        isLoadDataed = true;
    }

    protected void onLazyLoad() {

    }




    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }
}
