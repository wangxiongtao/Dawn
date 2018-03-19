package com.dawn.modules;

import android.os.Bundle;
import android.view.View;

import com.dawn.R;
import com.dawn.base.BaseActivity2;


public class ShowErrorActivity extends BaseActivity2 {


    @Override
    protected boolean showBaseToolBar() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show_error;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

    public void button(View v){
        showLayout(STATE_NO_DATA);

    }
}
