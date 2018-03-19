package com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

import com.util.LogUtil;

/**
 * Created by Administrator on 2018/3/16 0016.
 */

public class MyArcView  extends View{
    private Paint paint;
    private RectF rect;
    private int angle;
    private int count;
    private Runnable runnable;
    private Handler handler=new Handler();
    public MyArcView(Context context) {
        super(context);
        init();
    }

    public MyArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    public MyArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        rect=new RectF(100,100,0,0);



        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    angle++;
                    count++;
                    if(count>360){
                        return;
                    }
                    postInvalidate();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }).start();



    }
    public void startMyAnia(){
        MyAnimation animation=new MyAnimation();
        animation.setDuration(3000);
        animation.setInterpolator(new LinearInterpolator());
        startAnimation(animation);
    }

   class MyAnimation extends Animation{
       @Override
       protected void applyTransformation(float interpolatedTime, Transformation t) {
           super.applyTransformation(interpolatedTime, t);
           LogUtil.i("===applyTransformation========>"+interpolatedTime);
       }
   }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rect.right=getWidth()-100;
        rect.bottom=getHeight()-100;
        paint.setStrokeWidth(100);

        if(count<=120) {


            paint.setColor(Color.RED);
            canvas.drawArc(rect, 0, angle, true, paint);
        }else if(count<=240){
            paint.setColor(Color.RED);
            canvas.drawArc(rect, 0, 120, true, paint);
            LogUtil.i("========>"+count+">=120");

            paint.setColor(Color.GREEN);
            canvas.drawArc(rect,120,angle-120,true,paint);

        }else if(count<=360){
            paint.setColor(Color.RED);
            canvas.drawArc(rect, 0, 120, true, paint);
            LogUtil.i("========>"+count+">=120");

            paint.setColor(Color.GREEN);
            canvas.drawArc(rect,120,120,true,paint);
            paint.setColor(Color.BLUE);
            canvas.drawArc(rect,240,angle-240,true,paint);
        }



//        handler.postDelayed(new MyRunable(canvas),100);


//        LogUtil.i("===count=====>"+count);
//
//            LogUtil.i("========>"+count+"<120");
//            paint.setColor(Color.RED);
//            canvas.drawArc(rect, 0, angle, false, paint);
//
//         if(count>=120){
//            LogUtil.i("========>"+count+">=120");
//            paint.setColor(Color.GREEN);
//            canvas.drawArc(rect,120,angle,false,paint);
//
//
//        }








//
//        paint.setColor(Color.BLUE);
//        canvas.drawArc(rect,240,120,false,paint);

    }
}
