package com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/3/15 0015.
 */

public class MyGroup extends ViewGroup {
    public MyGroup(Context context) {
        super(context);
    }

    public MyGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i=0;i<getChildCount();i++){
            View view=getChildAt(i);

            int left=getMeasuredWidth()-view.getMeasuredWidth();
            int top=getMeasuredHeight()-view.getMeasuredWidth();


            view.layout(left/2,top/2,left/2+view.getMeasuredWidth(),top/2+view.getMeasuredHeight());
        }



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setStrokeWidth(10);
        Rect rect=new Rect(100,100,getMeasuredWidth(),getMeasuredHeight());
//        canvas.drawLine(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(100,100,getMeasuredWidth(),getMeasuredHeight(),paint);

    }
}
