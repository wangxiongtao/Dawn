package com.view;

import android.content.Context;
import android.graphics.Canvas;
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
 * Created by Administrator on 2018/7/13 0013.
 */

public class SwitchButton2 extends LinearLayout {
    private RectF rectF=new RectF();
    private Paint paint;
    public SwitchButton2(Context context) {
        super(context);
        init();
    }

    public SwitchButton2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SwitchButton2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.switch_button, this, true);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        setWillNotDraw(false);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.i("==setOnClickListener============>");
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.i("==onTouchEvent============>" + event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        LogUtil.i("==onInterceptTouchEvent============>" + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }
}
