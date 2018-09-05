package com.dawn.modules.workmanager;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dawn.R;
import com.util.LogUtil;

import java.util.UUID;

import androidx.work.WorkManager;
import androidx.work.WorkStatus;

public class WorkManagerActivity extends AppCompatActivity {;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_manager);
        finish();

       
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.i("===onStart====>");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.i("===onResume====>");
    }

    public void onClick(View v){
        PullEngine pullEngine=new PullEngine();
        UUID uuid=pullEngine.schedulePull();
        LogUtil.i("=uuid====>"+uuid);
        WorkManager.getInstance().getStatusById(uuid).observe(WorkManagerActivity.this, new Observer<WorkStatus>() {
            @Override
            public void onChanged(@Nullable WorkStatus workStatus) {
                    String str=workStatus.getOutputData().getString("key_pulled_result","");
                LogUtil.i("=onChanged=======>"+str);
            }
        });

    }
}
