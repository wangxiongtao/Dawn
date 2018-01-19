package com.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/10/24.
 * 仿今日头条对话框
 */

public class ToDaysDialog extends View {
    private Paint mPaint=new Paint();
    private Bitmap dsBitmap;
    private RectF dsRecf;
    private RectF rectF=new RectF();
    private float percent;
    private float mMoveWidth=10;
    private Xfermode xfermode;
    private PorterDuff.Mode mode= PorterDuff.Mode.SRC_IN;
    public ToDaysDialog(Context context) {
        super(context);
        init();
    }

    public ToDaysDialog(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ToDaysDialog(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        xfermode= new PorterDuffXfermode(mode);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
////        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
//        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
//
//        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
//        int heigthSize=MeasureSpec.getSize(heightMeasureSpec);
//
//        int resultW=widthSize;
//        int resultH=heigthSize;
//        if(widthMode==MeasureSpec.AT_MOST){
//            resultW=dsBitmap.getWidth();
//        }
//        if(heightMode==MeasureSpec.AT_MOST){
//            resultH=dsBitmap.getHeight();
//        }
//        setMeasuredDimension(resultW,resultH);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveCount=canvas.saveLayer(dsRecf,mPaint,Canvas.ALL_SAVE_FLAG);
        mPaint.setFilterBitmap(true);
        mPaint.setAntiAlias(true);
        canvas.drawBitmap(dsBitmap,null,dsRecf,mPaint);
        mPaint.setXfermode(xfermode);
        mPaint.setColor(Color.parseColor("#eeeeee"));
        mPaint.setStyle(Paint.Style.FILL);
        rectF.set(percent*(getWidth()+getHeight())-getHeight() ,0,percent*(getWidth()*getHeight())-getHeight()*mMoveWidth,getHeight());
        canvas.skew(0.5f,0);
        canvas.drawRect(rectF,mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(saveCount);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        dsRecf=new RectF(0,0,getWidth(),getHeight());
    }
    public void startAnim(){
        final ValueAnimator valueAnimator=ValueAnimator.ofFloat(0,1);
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                percent= (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }
    public void start(int  drawableId){
        dsBitmap= BitmapFactory.decodeResource(getResources(),drawableId);
        startAnim();
    }
}
