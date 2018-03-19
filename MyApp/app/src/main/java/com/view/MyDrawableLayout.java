package com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.dawn.R;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public class MyDrawableLayout extends LinearLayout {
    Paint paint;
    int distance;
    int len;
    public MyDrawableLayout(Context context) {
        super(context);
        init();
    }

    public MyDrawableLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyDrawableLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#ff6600"));
        distance= (int) getResources().getDimension(R.dimen.r);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawCircle(0,0,getResources().getDimension(R.dimen.r)*2,paint);
        canvas.drawCircle(getWidth(),0,getResources().getDimension(R.dimen.r)*2,paint);
        paint.setStrokeWidth(10);


//        canvas.drawLine(getWidth()/2,0,getWidth()/2,distance*2,paint);
        canvas.drawLine(getWidth()/2,0,getWidth()/2,10,paint);
        canvas.drawLine(getWidth()/2,20,getWidth()/2,30,paint);
    }
}

