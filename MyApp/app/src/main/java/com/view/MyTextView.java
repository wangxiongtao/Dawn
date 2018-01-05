package com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import com.dawn.R;
import com.util.LogUtil;

/**
 * Created by Administrator on 2017/12/20.
 */

public class MyTextView extends TextView {
    private int mWidth;
    private int mHeight;
    private Paint paint;

    public MyTextView(Context context) {
        super(context);
        paint=new Paint();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint=new Paint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth=getWidth();
        mHeight=getHeight();
        mHeight=mHeight+10;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        LogUtil.i("==mWidth========>"+mWidth);
        LogUtil.i("==mHeight========>"+mHeight);
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);                    //设置画笔颜色
        canvas.drawColor(Color.WHITE);                  //设置背景颜色
        paint.setStrokeWidth((float) 1.0);//设置线宽
        paint.setUnderlineText(true);
        canvas.drawLine(0, (float) (2.4*mHeight/3), mWidth,(float) (2.4*mHeight/3), paint);
        Paint paint_text = new Paint();//绘制直线
        paint_text.setAntiAlias(true);
        paint_text.setTextSize(getResources().getDimensionPixelSize(R.dimen.widget_margins));
       canvas.drawText("100",0,mHeight,paint_text);
    }
}
