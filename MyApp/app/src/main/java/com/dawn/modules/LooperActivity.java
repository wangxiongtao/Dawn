package com.dawn.modules;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dawn.R;
import com.util.LogUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LooperActivity extends AppCompatActivity {
    private Handler handler;
    private Runnable runnable;
    boolean isLooper=true;
    private ScheduledExecutorService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looper);
        handler=new Handler();
    }

    public void handler(View view){
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(!isLooper){
                    return;
                }
                handler.postDelayed(this,1000);
                LogUtil.i("===handler 轮询========>"+this);

            }
        });






    }
    public void scheduledExecutor(View view){
         service=  Executors.newScheduledThreadPool(1);
         ExecutorService service1=  Executors.newFixedThreadPool(1);

         service1.execute(new Runnable() {
             @Override
             public void run() {

             }
         });

        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                LogUtil.i("===scheduledExecutor 轮询========>"+this);
            }
        },1,1,TimeUnit.SECONDS);


        service.execute(new Runnable() {
            @Override
            public void run() {

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        handler.removeCallbacksAndMessages(null);
        isLooper=false;
        service.shutdown();

    }
}
