package com.view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class SquareEditext extends android.support.v7.widget.AppCompatEditText {
    public SquareEditext(Context context) {
        super(context);
    }

    public SquareEditext(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareEditext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
