package com.view.growthvalue;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.dawn.R;
import com.util.LogUtil;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class GrowthValueView extends View {
    private Paint currentPaint;//当前进度
    private Paint maxPaint;//总的进度
    private Paint textPaint;
    private Paint circlePaint;
    private RectF currentRect;
    private RectF maxRect;
    private Rect rect;//用于得出文字的宽度


    private float percent;//百分比（0f-1f）
    private float truePercent;
    private int progressH = 10;//进度条的长度
    private int progressW;//进度条的宽度
    private int progressCorner=6;//进度条弧度
    private AnimationEndListener endListener;
    private ValueAnimator animator;

    private int top=60;//距离上面的距离
    private int left=100;//距离左和右距离
    private int cirR=5;//小圆的半径的一部分
    private int textTop=70;//文字距离进度条的高度
    private int textToRight=20;//文字距离右边的距离
    private long duration=1500;//动画执行时间



    public GrowthValueView(Context context) {
        super(context);
        init();
    }

    public GrowthValueView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GrowthValueView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initValues();
        currentPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        maxPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        currentPaint.setColor(Color.parseColor("#998860"));
        maxPaint.setColor(Color.parseColor("#000000"));
        circlePaint.setColor(Color.parseColor("#DFCC88"));

        textPaint.setTextSize(30);

        currentRect = new RectF(left, 0, 0, 0);
        maxRect = new RectF(left, 0, 0, 0);

        rect=new Rect();

        animator = ValueAnimator.ofFloat(0, 1.f);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                truePercent = value * percent;
                invalidate();

            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (endListener != null) {
                    endListener.animationEnd(progressW*truePercent+left, progressH / 2 + top);
                }
            }
        });

    }

    private void initValues(){
        int dp10= (int) getResources().getDimension(R.dimen.dp_10);
        progressH= (int) getResources().getDimension(R.dimen.dp_3);
        progressCorner= (int) getResources().getDimension(R.dimen.dp_2);
        cirR= (int) getResources().getDimension(R.dimen.dp_2);
        top= dp10*2;
        left= dp10*3;
        textTop= (int) (dp10*2.5);
        textToRight= 2*(int) getResources().getDimension(R.dimen.dp_2)+(int) getResources().getDimension(R.dimen.dp_3);


    }

    public void setAnimationEndListener(AnimationEndListener endListener) {
        this.endListener = endListener;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        progressW= getMeasuredWidth()-left*2;

        int bottom = top + progressH;
        float right =progressW*truePercent+left;

        currentRect.top = top;
        currentRect.bottom = bottom;
        currentRect.right = right;


        maxRect.top = top;
        maxRect.bottom = bottom;
        maxRect.right = progressW+left;


        canvas.drawRoundRect(maxRect, progressCorner, progressCorner, maxPaint);//画背景黑色矩形
        canvas.drawRoundRect(currentRect, progressCorner, progressCorner, currentPaint);//画进度

        canvas.drawCircle(right, progressH / 2 + top, progressH / 2 + cirR, circlePaint);//画圆

        textPaint.setColor(Color.parseColor("#ffffff"));
        canvas.drawText("距离下一个成长值为100",left,bottom+textTop,textPaint);


        String text="158426911";

        textPaint.setColor(Color.parseColor("#CFB974"));
        textPaint.getTextBounds(text,0,text.length()-1,rect);

        int textW=rect.right-rect.left+textToRight;

        canvas.drawText(text,getMeasuredWidth()-left-textW,bottom+textTop,textPaint);

    }

    public void setPercent(float percent) {
        this.percent = percent;
        animator.setDuration((long) (duration * percent));
        animator.start();
    }

    public interface AnimationEndListener {
        void animationEnd(float x, float y);
    }

}
