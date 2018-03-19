package com.dawn.modules;

import android.os.Bundle;
import android.view.View;

import com.dawn.R;
import com.dawn.base.BaseActivity;
import com.dawn.presenter.BasePresenter;
import com.dawn.presenter.MyPresenter;
import com.util.ToastUtil;

public class MVPActivity extends BaseActivity {
    private MyPresenter presenter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_mvp;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected BasePresenter initPresenter() {
        presenter=new MyPresenter(this);
        return presenter;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {


    }
    public void onClick2(View v){
//        ToastUtil.showShort(v.getContext(),"click");
        presenter.getData();


    }


    @Override
    public void handlerView(int what, Object data) {
        ToastUtil.showShort(this,what+"--"+data.toString());
    }
}
