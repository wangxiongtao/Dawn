package com.dawn.service;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/10/19.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {
    int i=0;

    @Override
    public void onCreate() {
        super.onCreate();
//        Log.i("aaa","=====onCreate=======>");


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.i("aaa","=====onStartCommand=======>");
        return START_STICKY;
    }
    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i("aaa","============>"+(i++));

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//
//                    Log.i("aaa","============>"+i);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    i++;
//                }
//            }
//        }).start();
        startService();

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
    public void startService(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            JobScheduler scheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
            ComponentName componentName = new ComponentName(getPackageName(), MyJobService.class.getName());
            JobInfo.Builder builder = new JobInfo.Builder(1, componentName);
//
//        String delay = mDelayEditText.getText().toString();
//        if (delay != null && !TextUtils.isEmpty(delay)) {
//            //设置JobService执行的最小延时时间
//            builder.setMinimumLatency(Long.valueOf(delay) * 1000);
//        }
//        String deadline = mDeadlineEditText.getText().toString();
//        if (deadline != null && !TextUtils.isEmpty(deadline)) {
//            //设置JobService执行的最晚时间
//            builder.setOverrideDeadline(Long.valueOf(deadline) * 1000);
//        }
//        boolean requiresUnmetered = mWiFiConnectivityRadioButton.isChecked();
//        boolean requiresAnyConnectivity = mAnyConnectivityRadioButton.isChecked();
//        //设置执行的网络条件
//        if (requiresUnmetered) {
//            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);
//        } else if (requiresAnyConnectivity) {
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
            builder.setMinimumLatency(TimeUnit.MILLISECONDS.toMillis(10));
//            builder.setPersisted(true);
//        builder.setMinimumLatency(200);
//        }
//        builder.setRequiresDeviceIdle(mRequiresIdleCheckbox.isChecked());//是否要求设备为idle状态
//        builder.setRequiresCharging(mRequiresChargingCheckBox.isChecked());//是否要设备为充电状态

            int i = scheduler.schedule(builder.build());
//            Log.i("aaa", "=====schedule=======>" + i);
        }
    }
}
