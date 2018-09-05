package com.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.dawn.R;
import com.util.LogUtil;

/**
 * Created by Administrator on 2018/7/12 0012.
 */

public class SwitchButton extends LinearLayout {
    private Paint paint;
    private int margin;
    private RectF rectF = new RectF();
    private ValueAnimator animator;
    private int slideW;
    private float x;
    private float x1;
    private float y;
    float dx1 = 0;
    private int maxSlideDistance;
    private int minSlideDistance;
    boolean isMoving = false;
    private OnCheckListener checkListener;

    public SwitchButton(Context context) {
        super(context);
        init();
    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SwitchButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.switch_button, this, true);
        minSlideDistance=margin = (int) getResources().getDimension(R.dimen.dp_3);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        setWillNotDraw(false);
        animator = ValueAnimator.ofFloat(0, 1.0f);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                rectF.left = (float) animation.getAnimatedValue();
                invalidate();
            }
        });

    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        paint.setColor(Color.parseColor("#ff0000"));
        slideW = getWidth() / 2 - 2 * margin;
        rectF.left = margin;
        rectF.top = margin;
        maxSlideDistance = slideW + margin * 3;
        rectF.bottom = getHeight() - margin;


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.i("====onTouchEvent====>"+event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                x1 = event.getX();
                y = event.getY();
                isMoving = false;
                return true;
            case MotionEvent.ACTION_MOVE:
                float dx = event.getX() - x;
                float dy = event.getY() - y;
                if (Math.abs(dx) > Math.abs(dy) && Math.abs(dx) > margin) {
                    if (isInSlideView(event.getX())) {
                        isMoving = true;
                        rectF.left += dx1;
                        dx1 = event.getX() - x1;
                        invalidate();
                        x1 = event.getX();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:

                if (isMoving) {
                    isMoving = false;
                    if (rectF.left <= getWidth() / 4) {//滑动距离小于getWidth() / 4
                        startAnim(minSlideDistance);
                    } else {
                        startAnim(maxSlideDistance);
                    }
                } else {
                    if (!isCheckAtLeft() && isTouchLeft(event.getX())) {//触摸了左边
                        startAnim(minSlideDistance);

                    } else if (!isCheckAtRight() && !isTouchLeft(event.getX())) {
                        startAnim(maxSlideDistance);
                    }
                }

                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (rectF.left > maxSlideDistance) {
            rectF.left = maxSlideDistance;
        }
        if (rectF.left < minSlideDistance) {
            rectF.left = minSlideDistance;
        }

        rectF.right = slideW + rectF.left;
        canvas.drawRoundRect(rectF, 20, 20, paint);
        if (checkListener == null) {
            return;
        }
        if (isCheckAtRight()) {
            checkListener.onCheck(false);
        }
        if (isCheckAtLeft()) {
            checkListener.onCheck(true);
        }
    }

    public void setOnCheckListener(OnCheckListener checkListener) {
        this.checkListener = checkListener;
    }

    private boolean isInSlideView(float x) {
        return x <= rectF.right && x >= rectF.left;

    }

    private boolean isTouchLeft(float x) {
        return x <= getWidth() / 2;
    }

    public boolean isCheckAtRight() {
        return rectF.left == maxSlideDistance;
    }

    public boolean isCheckAtLeft() {
        return rectF.left == minSlideDistance;
    }

    private void startAnim(int toY) {
        animator.setFloatValues(rectF.left, toY);
        animator.setDuration(1000);
        animator.start();
    }

    public interface OnCheckListener {
        void onCheck(boolean isCheckAtLeft);
    }


}
