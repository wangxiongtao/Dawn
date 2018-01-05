package com.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/12/21.
 */

public class MyLayout2 extends LinearLayout {
    private int mWidth;
    private  int pad=30;
    public MyLayout2(Context context) {
        super(context);
    }

    public MyLayout2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View child = this.getChildAt(i);
            this.measureChild(child, widthMeasureSpec, heightMeasureSpec);
//            int cw = child.getMeasuredWidth();
//            // int ch = child.getMeasuredHeight();
            MarginLayoutParams lp = (MarginLayoutParams) getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            //子View占据的高度
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {


        mWidth=getMeasuredWidth();
        View v1=getChildAt(0);
        View v2=getChildAt(1);
        if(v1.getMeasuredWidth()+v2.getMeasuredWidth()+pad<=mWidth){
            v1.layout(0,0,v1.getMeasuredWidth(), v1.getMeasuredHeight());
            v2.layout(v1.getMeasuredWidth()+pad,0,v1.getMeasuredWidth()+pad+v2.getMeasuredWidth(), v2.getMeasuredHeight());
        }else {
            int realLeftWidth=mWidth-v2.getMeasuredWidth()-pad;
            v1.layout(0,0,realLeftWidth, v1.getMeasuredHeight());
            v2.layout(realLeftWidth+pad,0,realLeftWidth+pad+v2.getMeasuredWidth(), v2.getMeasuredHeight());
            ViewGroup.LayoutParams lp=v1.getLayoutParams();
            lp.width=realLeftWidth;
            v1.setLayoutParams(lp);
        }






    }


}
