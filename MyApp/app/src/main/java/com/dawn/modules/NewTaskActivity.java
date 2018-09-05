package com.dawn.modules;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dawn.R;
import com.util.LogUtil;

public class NewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        LogUtil.i("==NewTaskActivity==taskId===>"+getTaskId());
    }
}
