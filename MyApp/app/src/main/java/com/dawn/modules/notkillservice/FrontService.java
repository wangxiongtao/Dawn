package com.dawn.modules.notkillservice;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.dawn.R;
import com.util.LogUtil;

import java.util.Date;

public class FrontService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        frontService();
    }

    public FrontService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    LogUtil.i("=FrontService======new Date()=======>" + new Date());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();




        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 前台服务
     */
    private void frontService() {
        Notification.Builder mBuilder = new Notification.Builder(this);
        mBuilder.setShowWhen(false);
        mBuilder.setAutoCancel(false);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        mBuilder.setContentText("thisiscontent");
        mBuilder.setContentTitle("this is title");
        startForeground(110, mBuilder.build());
        LogUtil.i("=======frontService===>");
    }
}
