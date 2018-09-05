package com.dawn.modules.workmanager;

import android.support.annotation.NonNull;

import com.util.LogUtil;

import androidx.work.Data;
import androidx.work.Worker;

/**
 * Created by Administrator on 2018/5/21 0021.
 */

public class PullWorker extends Worker {
    @NonNull
    @Override
    public WorkerResult doWork() {
        boolean isOk=getInputData().getBoolean("key_accept_bg_work",false);
        LogUtil.i("===PullWorker====isOk===>"+isOk);
        if(isOk) {
            try {
                Thread.sleep(5000); //模拟长时间工作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String pulledResult = startPull();
            Data data= new Data.Builder().putString("key_pulled_result", pulledResult).build();
            setOutputData(data);

            return WorkerResult.SUCCESS;
        } else {
            return WorkerResult.FAILURE;
        }
    }
     String startPull() {
        return "szw [worker] pull messages from backend";
    }
}
