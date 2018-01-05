package com.view.toast;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;



/**
 * Created by Administrator on 2017/12/12.
 */

public class ToastAnimationView extends android.support.v7.widget.AppCompatTextView {
    private int mHeight;
    private boolean layout=true;
//    private Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            TranslateAnimation anim1 = new TranslateAnimation(0, 0, 280, 0);
//            anim1.setDuration(3000);
//            anim1.setInterpolator(new DecelerateInterpolator());
//            anim1.setFillAfter(true);
//            startAnimation(anim1);
//        }
//    };
    public ToastAnimationView(Context context) {
        super(context);
    }

    public ToastAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ToastAnimationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mHeight=getHeight();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mHeight=getHeight();
//        if(layout){
//            layout=false;
//            layout(left,top-mHeight,right,bottom-mHeight);
//            showAnimaToast();
//        }




    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();



    }

    public void showAnimaToast(){
//        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation anim = new TranslateAnimation(0, 0, -150, 100);
        anim.setDuration(5000);
        anim.setInterpolator(new OvershootInterpolator());
        anim.setFillAfter(true);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//               handler.sendEmptyMessageDelayed(0,100);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TranslateAnimation anim1 = new TranslateAnimation(0, 0, 100, -150);
                anim1.setDuration(1000);
                anim1.setInterpolator(new DecelerateInterpolator());
                anim1.setFillAfter(true);
                startAnimation(anim1);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        startAnimation(anim);


    }

}
