package com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

import com.util.LogUtil;
import com.util.ToastUtil;

/**
 * Created by Administrator on 2018/3/14 0014.
 */

public class InputPwdView extends android.support.v7.widget.AppCompatEditText {
    private Paint contentPaint;
    private Paint linePaint;
    private Paint pointPaint;
    private Rect rect;
    private int showCount=6;
    private int pointRadius=7;

    public InputPwdView(Context context) {
        super(context);
        init();
    }

    public InputPwdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InputPwdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(),getMeasuredWidth()/showCount);
    }








    private void init(){
        setBackgroundColor(Color.WHITE);
        setTextColor(Color.WHITE);

        contentPaint =new Paint(Paint.ANTI_ALIAS_FLAG);
        contentPaint.setStyle(Paint.Style.STROKE);
        contentPaint.setStrokeWidth(2);
        contentPaint.setColor(Color.parseColor("#a7a7a7"));


        rect=new Rect(0,0,0,0);

        linePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStrokeWidth(2);
        linePaint.setColor(Color.parseColor("#a7a7a7"));

        pointPaint=new Paint(Paint.ANTI_ALIAS_FLAG);

    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogUtil.i("======onDraw======>");
        int w=getWidth();
        int h=getHeight();
        rect.right=w;
        rect.bottom=h;
        canvas.drawRect(rect, contentPaint);
        for (int i=1;i<=showCount-1;i++){//画分割线
            canvas.drawLine(h*i,0,h*i,h,linePaint);
        }

        int len=getText().toString().trim().length();
        for (int i=0;i<len;i++){
            canvas.drawCircle(h/2+h*i,h/2,pointRadius,pointPaint);
        }
        if(len==showCount){
            ToastUtil.show(getContext(),"输入完毕",0);
        }
    }
}
