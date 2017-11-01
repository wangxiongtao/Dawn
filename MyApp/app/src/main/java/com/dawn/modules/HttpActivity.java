package com.dawn.modules;

import android.os.Bundle;
import android.view.View;

import com.base.BaseActivity;
import com.dawn.R;
import com.dawn.http.request.MyRequest;

public class HttpActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_http;
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
    public void onClick(View v){
//        Log.i("aaa","====onClick======>");
        MyRequest request=new MyRequest(0);
        request.id="0";
        request.name="0";
        request.age=0;
        request.doRequest(this);
//        MyRequest request1=new MyRequest(1);
//        request1.id="1";
//        request1.name="1";
//        request1.age=1;
//        request1.doRequest(this);
//        LoginRequest request2=new LoginRequest(2);
//        request2.name="login2";
//        request2.doRequest(this);
//        LoginRequest request3=new LoginRequest(3);
//        request3.name="login3";
//        request3.doRequest(this);
//        LoginRequest request4=new LoginRequest(4);
//        request4.name="login4";
//        request4.doRequest(this);
//        LoginRequest request1=new LoginRequest(1);
//        request1.name="login";
//        request1.doRequest(this);
    }

    @Override
    public void onHttpSuccess(String response, int tag) {
        super.onHttpSuccess(response, tag);
    }
}
