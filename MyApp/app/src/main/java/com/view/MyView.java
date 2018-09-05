package com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

import com.util.LogUtil;

/**
 * Created by Administrator on 2017/12/5.
 */

public class MyView extends View {
    public MyView(Context context) {
        super(context);
        Scroller scroller=new Scroller(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Paint paint=new Paint();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if(changed){
//            layout(0,99,getMeasuredWidth(),getMeasuredHeight()+99);
        }




    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        if (widthMode == MeasureSpec.EXACTLY) {
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        } else {

        LogUtil.i("=getPaddingLeft()==============>"+getPaddingLeft());
//        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setStrokeWidth(10);
        Rect rect=new Rect(100,100,getMeasuredWidth(),getMeasuredHeight());
        canvas.drawLine(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);


    }
}
