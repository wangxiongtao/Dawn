package com.view.growthvalue;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;



/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class FlashCircleView extends View {
    private Paint circlePaint;
    private Paint ripplePaint;
    private Paint ripplePaint2;
    private Paint ripplePaint3;
    private int radius;
    private int radius2;
    private int radius3;
    private float x;
    private float y;
    private int n=0;
    private Handler handler=new Handler();
    public FlashCircleView(Context context) {
        super(context);
        init();
    }

    public FlashCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FlashCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        circlePaint =new Paint(Paint.ANTI_ALIAS_FLAG);
        ripplePaint =new Paint(Paint.ANTI_ALIAS_FLAG);
        ripplePaint2 =new Paint(Paint.ANTI_ALIAS_FLAG);
        ripplePaint3 =new Paint(Paint.ANTI_ALIAS_FLAG);
//        circlePaint.setColor(Color.parseColor("#DFCC88"));
//        ripplePaint.setColor(Color.parseColor("#FFF0B9"));
        circlePaint.setColor(Color.parseColor("#ff0000"));
        ripplePaint.setColor(Color.BLUE);
        ripplePaint2.setColor(Color.BLUE);
        ripplePaint3.setColor(Color.BLUE);

//        ripplePaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x=getMeasuredWidth()/2;
        y=getMeasuredHeight()/2;

////        for (int i=0;i<3;i++){
//
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        if(radius>=50){
//                            return;
//                        }
//                        radius++;
//                        canvas.drawCircle(x,y,radius,ripplePaint);
//                        handler.postDelayed(this,1000);
//                    }
//                },1000);



//        }

        if((radius++)<=60){
            canvas.drawCircle(x,y,radius,ripplePaint);
        }
       if((radius2++)<=50){
           canvas.drawCircle(x,y,radius2,ripplePaint2);
       }
       if((radius3++)<=40){
           canvas.drawCircle(x,y,radius3,ripplePaint3);
       }



//        LogUtil.i("====onDraw======>"+radius);

        canvas.drawCircle(x,y,30,circlePaint);
        invalidate();


    }
}
