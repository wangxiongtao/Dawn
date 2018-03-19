package com.dawn.modules;

import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;

import com.dawn.R;
import com.view.MyArcView;

public class MyView4Activity extends AppCompatActivity {
    private MyArcView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view4);
        view=findViewById(R.id.arc);

        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                view.startMyAnia();
                return false;
            }
        });
    }
}
