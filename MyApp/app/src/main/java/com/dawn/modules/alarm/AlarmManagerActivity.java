package com.dawn.modules.alarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dawn.R;

public class AlarmManagerActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);
        button=findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
//
//                int anHour = 3000;   // 这是一小时的毫秒数
//
//                long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
//                Intent i = new Intent(v.getContext(), LongRunningService.class);
//                PendingIntent pi = PendingIntent.getService(v.getContext(), 0, i, 0);
//
//                manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime,anHour, pi);
//                Intent intent=new Intent(v.getContext(),LongRunningService.class);
//                startService(intent);


            }
        });
    }
}
