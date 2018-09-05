package com.dawn.modules.workmanager;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import androidx.work.Data;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

/**
 * Created by Administrator on 2018/5/23 0023.
 */

public class PullEngine {
    public UUID schedulePull(){
       PeriodicWorkRequest.Builder builder= new PeriodicWorkRequest.Builder(PullWorker.class,3, TimeUnit.SECONDS);
       builder.setInputData(new Data.Builder().putBoolean("key_accept_bg_work", true).build());
        PeriodicWorkRequest request=builder.build();
        WorkManager.getInstance().enqueue(request);
        return request.getId();


    }
}
