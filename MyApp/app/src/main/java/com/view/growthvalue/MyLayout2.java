package com.view.growthvalue;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class MyLayout2 extends RelativeLayout {
    private WaveView waveView;
    private TextView valueTv;
    GrowthValueView valueView;
    private Handler handler=new Handler();
    public MyLayout2(Context context) {
        super(context);
        init();
    }

    public MyLayout2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyLayout2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        waveView=new WaveView(getContext());
        waveView.setCxy(30,30);
        waveView.setDuration(1000);
        waveView.setStyle(Paint.Style.FILL);
        waveView.setColor(Color.RED);
        waveView.setInterpolator(new LinearInterpolator());
        waveView.start();



    }




}
