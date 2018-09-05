package com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/7/13 0013.
 */

public class AnimView extends View {
    private BitmapDrawable mDrawable;

    private int mViewWidth;
    private int mViewHeight;
    private Paint paint = new Paint();
    private int margin = 10;
    private Rect rect = new Rect(0, 0, 400, 220);

    public AnimView(Context context) {
        super(context);
        init();

    }

    public AnimView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public AnimView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
//        mDrawable = new BitmapDrawable(bitmap);
//        mDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //构造两个画笔，一个红色，一个绿色
        Paint paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 3);
        Paint paint_red = generatePaint(Color.RED, Paint.Style.STROKE, 3);


        //构造一个矩形

        rect.left += margin;
        rect.right += margin;

//
        canvas.drawRect(rect, paint_green);
        //在平移画布前用绿色画下边框

        //平移画布后,再用红色边框重新画下这个矩形
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        },1000);

    }

    private Paint generatePaint(int color, Paint.Style style, int width) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }
}
