package com.dawn.modules;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.dawn.R;
import com.util.LogUtil;
import com.view.MyArcView;
import com.view.growthvalue.GrowthValueView;
import com.view.growthvalue.WaveView;

public class MyView4Activity extends AppCompatActivity {

    private GrowthValueView valueView;
    private WaveView waveView;
    private MyArcView view;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LogUtil.i("==handleMessage=========>"+msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view4);
        view=findViewById(R.id.arc);
        valueView=findViewById(R.id.value);
        waveView=findViewById(R.id.wave);

        valueView.setAnimationEndListener(new GrowthValueView.AnimationEndListener() {
            @Override
            public void animationEnd(float x, float y) {
                LogUtil.i("==animationEnd==>"+x);
                LogUtil.i("==animationEnd==>"+y);
                waveView.setCxy(x,y);
                waveView.setDuration(900);
                waveView.setStyle(Paint.Style.FILL);
                waveView.setColor(Color.parseColor("#DFCC88"));
                waveView.start();
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        waveView.stop();
//                    }
//                },900);


            }
        });
//        valueView.setPercent(0.5f);
//        waveView.setCxy(540,40);
//        waveView.setDuration(1000);
//        waveView.setStyle(Paint.Style.FILL);
//        waveView.setColor(Color.RED);
//        waveView.start();






        handler.sendMessage(new Message());
//        handler.sendMessage(null);
//        handler.sendMessage(new Message());


    }
}
