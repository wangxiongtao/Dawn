package com.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dawn.R;
import com.dawn.bean.MyDate;
import com.dawn.modules.adapter.MyAdapter;
import com.util.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class MyCalendarView extends LinearLayout{
    private GridView mGridView;
    private List<MyDate> dateList;
    private MyAdapter adapter;
    private TextView tv;

    private AdapterView.OnItemClickListener clickListener;
    private float y;
    private int  lastY;

    public MyCalendarView(Context context) {
        super(context);
        init(context);
    }

    public MyCalendarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyCalendarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        View view=View.inflate(context, R.layout.mycalendar_layout,null);
        mGridView= (GridView) view.findViewById(R.id.gv);
        tv=view.findViewById(R.id.tvbelow);
        dateList=new ArrayList<>();
        dateList.clear();
        dateList.addAll(DateUtils.getDateList(2017,DateUtils.getNowMonth()));
        adapter=new MyAdapter(dateList);
        mGridView.setAdapter(adapter);
        addView(view);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setSelecPos(position);
                adapter.notifyDataSetChanged();
                if(clickListener!=null){
                    clickListener.onItemClick(parent,view,position,id);
                }
            }
        });

//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LinearLayout.LayoutParams lp= (LinearLayout.LayoutParams) getLayoutParams();
//                lp.topMargin=-500;
//                requestLayout();
//            }
//        });
        tv.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int y = (int) event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastY = y;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int offsetY = y - lastY;
//                        LinearLayout.LayoutParams lp= (LinearLayout.LayoutParams) getLayoutParams();
//                        lp.topMargin=offsetY;
//                        requestLayout();
//                        layout(getLeft()+0,
//                                getTop()+offsetY,
//                                getRight()+0,
//                                getBottom()+offsetY);
                        offsetTopAndBottom(offsetY);


//                Log.d("xinwa", "事件为" + event.getAction() + ",View距离左边的位置为" + getLeft() + ",X轴的偏移量为" + offsetX + ",移动的过程中相对父View的X坐标为"+x);
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
            }


                return true;
            }
        });

    }
    public void setDate(int year,int month){
        dateList.clear();
        dateList.addAll(DateUtils.getDateList(year,month));
        adapter.notifyDataSetChanged();
    }

    public void setClickListener(AdapterView.OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }


}
