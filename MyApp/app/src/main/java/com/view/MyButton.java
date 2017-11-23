package com.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.util.LogUtil;

/**
 * Created by Administrator on 2017/11/10.
 */

public class MyButton extends android.support.v7.widget.AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.i("=button====onTouchEvent======>");
        return super.onTouchEvent(event);
    }
}
