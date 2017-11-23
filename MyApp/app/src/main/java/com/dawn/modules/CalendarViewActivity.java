package com.dawn.modules;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.dawn.R;
import com.dawn.base.BaseActivity;
import com.view.MyCalendarView;

public class CalendarViewActivity extends BaseActivity {
        MyCalendarView calendarView;

    LinearLayout root;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_calendar_view;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        calendarView=findViewById(R.id.date);

        root=findViewById(R.id.root);
        calendarView.setDate(2017,11);
        calendarView.setClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                LinearLayout.LayoutParams lp= (LinearLayout.LayoutParams) calendarView.getLayoutParams();
//                lp.topMargin=-540;
//                calendarView.requestLayout();
//                calendarView.scrollTo(0,400);
            }
        });

    }

    @Override
    protected void setListener() {


    }

    @Override
    protected void initData() {

    }
}
