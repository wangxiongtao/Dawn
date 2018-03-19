package com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.util.LogUtil;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class MyEdittext extends android.support.v7.widget.AppCompatEditText {
    public MyEdittext(Context context) {
        super(context);
    }

    public MyEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogUtil.i("===MyEdittext===onDraw======>");
    }
}
