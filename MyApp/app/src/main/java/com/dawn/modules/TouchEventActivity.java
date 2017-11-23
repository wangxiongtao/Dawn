package com.dawn.modules;

import android.os.Bundle;
import android.view.MotionEvent;

import com.dawn.R;
import com.dawn.base.BaseActivity;
import com.util.LogUtil;
import com.view.MyButton;

public class TouchEventActivity extends BaseActivity {
    MyButton button;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_touch_event;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        button=findViewById(R.id.mybutton);

    }

    @Override
    protected void setListener() {
//        button.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
////                LogUtil.i("====onTouch=======>");
//                return true;
//            }
//        });


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.i("==activity==dispatchTouchEvent=======>");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void initData() {

    }
}
