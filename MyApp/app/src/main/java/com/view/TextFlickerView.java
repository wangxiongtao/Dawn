package com.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.support.annotation.IntRange;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by Administrator on 2018/5/2 0002.
 */

public class TextFlickerView extends AppCompatTextView {

    private static final String TAG = "TextFlickerView";
    //闪光的宽度
    public static final int SHADOW_W = 50;

    private Matrix mShadowMatrix;

    private LinearGradient mLinearGradient;

    private ValueAnimator mValueAnimator;

    private int mRepeatCount = 50;

    public TextFlickerView(Context context) {
        super(context);
    }

    public TextFlickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextFlickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        tryInitEngine(w);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mLinearGradient != null) {
            mLinearGradient.setLocalMatrix(mShadowMatrix);
        }
    }

    private void tryInitEngine(int w) {
        if (mShadowMatrix == null) {
            if (w > 0) {
                //控制阴影的Matrix，通过Matrix的变化来实现闪光的滑过效果
                mShadowMatrix = new Matrix();
                //因为使用了LinearGradient,所以Paint本身的color将毫无意义，所以colors的起始点的色值必须和本来色值一致
                int currentTextColor = getCurrentTextColor();
                //渐变色层.x0,y0是起点坐标，x1，y1是终点坐标
                mLinearGradient = new LinearGradient(0, 0, SHADOW_W, 0, new int[] {currentTextColor, Color.BLUE},
                        null, Shader.TileMode.CLAMP);
                //画笔设置Shader
                getPaint().setShader(mLinearGradient) ;
                //使用属性动画作为引擎，数值从-SHADOW变化到TextView本身的宽度。间隔时间未1500ms
                mValueAnimator = ValueAnimator.ofFloat(-SHADOW_W, w).setDuration(1500);
                mValueAnimator.setInterpolator(new LinearInterpolator());
                mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        //Matrix移动来实现闪光滑动
                        mShadowMatrix.setTranslate(value, 0);
                        invalidate();
                    }
                });
                mValueAnimator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        super.onAnimationRepeat(animation);
                        //每次动画重复时，将Matrix重置
                        mShadowMatrix.reset();
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mShadowMatrix.reset();
                    }
                });
                mValueAnimator.setRepeatCount(mRepeatCount);
            }
        }
    }

    public void setDuration(@IntRange(from = 1, to = 15) int second) {
        mRepeatCount = second - 1;
        if (mValueAnimator != null) {
            mValueAnimator.setRepeatCount(mRepeatCount);
        }
    }

    public void start() {
        if (mValueAnimator == null) {
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    tryInitEngine(getWidth());
                    if (mValueAnimator != null) {
                        mValueAnimator.start();
                    }
                }
            }, 100);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    private void release() {
        if (mValueAnimator != null) {
            mValueAnimator.removeAllListeners();
            mValueAnimator.cancel();
            mValueAnimator = null;
        }
        mShadowMatrix = null;
        mLinearGradient = null;
    }

}