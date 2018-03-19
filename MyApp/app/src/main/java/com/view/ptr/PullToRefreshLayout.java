package com.view.ptr;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.util.LogUtil;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class PullToRefreshLayout extends LinearLayout {
    private View mHeaderView;
    private View mContentView;
    private float mDy;
    private  float mLastY;


    public PullToRefreshLayout(Context context) {
        super(context);
        init();
    }

    public PullToRefreshLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PullToRefreshLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setOrientation(VERTICAL);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mHeaderView=getChildAt(0);
        mContentView=getChildAt(1);
        mHeaderView.layout(0,0,0,0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {


        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastY=ev.getY();
                LogUtil.i("===ACTION_DOWN===>");

                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.i("===ACTION_MOVE===>"+mDy);
                mDy=ev.getY()-mLastY;
                mLastY=ev.getY();
                LayoutParams lp= (LayoutParams) mHeaderView.getLayoutParams();
                lp.height= (int) (lp.height+mDy*lp.height);
                mHeaderView.setLayoutParams(lp);
//                mHeaderView.setPadding(0,0,0, (int) mDy);


//                offsetTopAndBottom((int) (mDy*0.5));




                return true;
            case MotionEvent.ACTION_UP:
                LogUtil.i("===ACTION_UP===>");
//                offsetTopAndBottom(-100);
                return true;
        }

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        return true;
    }
}
