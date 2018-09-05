package com.dawn.modules.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import com.util.LogUtil;

import java.util.Date;


/**
 * Created by Administrator on 2018/5/21 0021.
 */

public class LongRunningService extends Service {
    AlarmManager manager;
    Intent i;
    PendingIntent pi;
    @Override
    public void onCreate() {
        super.onCreate();
         manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        i = new Intent(this, AlarmReceiver.class);
        pi = PendingIntent.getBroadcast(this, 0, i, 0);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtil.i("==new Date()=======>" + new Date());

            }
        }).start();


//
        int anHour = 3000;   // 这是一小时的毫秒数

        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;


//                manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime,anHour, pi);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);


        return super.onStartCommand(intent, flags, startId);


    }
}
