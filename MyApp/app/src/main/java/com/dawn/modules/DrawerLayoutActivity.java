package com.dawn.modules;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.dawn.R;

import java.util.Date;

public class DrawerLayoutActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        drawerLayout=findViewById(R.id.drawer_layout);
        textView=findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                drawerLayout.openDrawer(Gravity.NO_GRAVITY);

                //时间选择器
                TimePickerView pvTime = new TimePickerBuilder(DrawerLayoutActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        Toast.makeText(v.getContext(), date.getDate(), Toast.LENGTH_SHORT).show();
                    }
                }).build();
                pvTime.show();

            }
        });
    }
}
