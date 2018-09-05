package com.dawn.modules.fragmenttest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dawn.R;
import com.dawn.modules.UmengActivity;
import com.util.FragmentUtil;
import com.util.LogUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    private List<android.support.v4.app.Fragment>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        EventBus.getDefault().register(this);
        list=new ArrayList<>();
        list.add(PlusOneFragment.newInstance(1));
        list.add(PlusOneFragment.newInstance(2));
        showFragment(0);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                showFragment(0);
                break;
            case R.id.btn2:
//                showFragment(1);
                doPhotoPrint();




                break;
            case R.id.btn3:
                startActivity(new Intent(v.getContext(), UmengActivity.class));
                break;
        }

    }

    public void showFragment(int pos){
        FragmentUtil.showFragment(getSupportFragmentManager(), pos, list, R.id.frame_layout);


    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void refreshOrderList(String event) {  //刷新列表
        LogUtil.i("=====消息来啦=======>"+event);
        showFragment(0);
        PlusOneFragment fragment= (PlusOneFragment) list.get(0);
        fragment.setText("adssadasdsadsadsadsad");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.i("=====onSaveInstanceState=======>");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.i("=====onStop=======>");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.i("=====onPause=======>");
    }
    private void doPhotoPrint() {
        PrintHelper photoPrinter = new PrintHelper(this);
        photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.common_google_signin_btn_icon_dark);
        photoPrinter.printBitmap("droids.jpg - test print", bitmap);
    }
}
