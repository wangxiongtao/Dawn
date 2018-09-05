package com.view.growthvalue;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dawn.R;
import com.util.LogUtil;


/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class MyLayout extends RelativeLayout {
    private WaveView waveView;
    private TextView valueTv;
    GrowthValueView valueView;
    private Handler handler=new Handler();
    public MyLayout(Context context) {
        super(context);
        init();
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
         valueView=new GrowthValueView(getContext());
        valueView.setPercent(0.0f);
        waveView=new WaveView(getContext());
        valueTv=new TextView(getContext());

        valueView.setAnimationEndListener(new GrowthValueView.AnimationEndListener() {
            @Override
            public void animationEnd(float x, float y) {
                LogUtil.i("===x==>"+x);
                LogUtil.i("===y==>"+y);
               initWaveView(x,y);



            }
        });
        addView(waveView);
        addView(valueView);
    }


    private void initWaveView(float x,float y){
        waveView.setCxy(x,y);

        waveView.setDuration(100);
        waveView.setStyle(Paint.Style.FILL);
        waveView.setColor(Color.parseColor("#DFCC88"));
//        waveView.setColor(Color.parseColor("#ff0000"));
        waveView.start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                waveView.stop();
                initValueText(x);
            }
        },600);
    }


    private void initValueText(float x){
        valueTv.setText("5225");
        valueTv.setTextColor(Color.parseColor("#DFCC87"));
        valueTv.setTextSize(8.0f);
        valueTv.setGravity(Gravity.CENTER);
        valueTv.setBackgroundResource(R.drawable.value_bg);

        addView(valueTv);

        ViewTreeObserver observer=valueTv.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                LogUtil.i("==vx=============>"+x);
                LogUtil.i("==valueTv.getWidth()=============>"+valueTv.getWidth());
                RelativeLayout.LayoutParams lp=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.leftMargin= (int) (x-valueTv.getWidth()/2);
                valueTv.setLayoutParams(lp);
                ScaleAnimation animation=new ScaleAnimation(0,1,0,1,valueTv.getWidth()/2,valueTv.getHeight()/2);
                animation.setDuration(500);
                valueTv.startAnimation(animation);



                observer.removeOnGlobalLayoutListener(this);


            }
        });
    }
    private void initBottomTxt(){
        TextView tv=new TextView(getContext());
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(10.0f);
        tv.setText("距下一等级还需1921成长值");


    }

}
