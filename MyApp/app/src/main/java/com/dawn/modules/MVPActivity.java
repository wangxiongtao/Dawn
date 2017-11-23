package com.dawn.modules;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.dawn.R;
import com.dawn.base.BaseActivity;
import com.dawn.presenter.MyPresenter;
import com.util.ToastUtil;

public class MVPActivity extends BaseActivity {

    private MyPresenter myPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mvp;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        myPresenter=new MyPresenter();

    }
    public void onClick2(View v){
//        ToastUtil.showShort(v.getContext(),"click");
        Message message=Message.obtain(mvpHandler,0);
        myPresenter.fun(message);
    }

    @Override
    protected void handlePMessage(Message msg) {
        switch (msg.what){
            case 0:
            ToastUtil.showShort(this,msg.obj.toString());
            break;
        }
    }
}
