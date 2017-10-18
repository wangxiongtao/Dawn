package com.dawn;

import android.os.Bundle;

import com.dawn.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mToolbar_Title_Txt.setText("测试");

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }
}
