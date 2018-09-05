package com.dawn.modules.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dawn.R;
import com.dawn.bean.MyDate;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class MyAdapter extends BaseAdapter {
    private List<MyDate>list;
    private int selectPos =-1;

    public MyAdapter(List<MyDate> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder=null;
        if(convertView==null){

            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_date,parent,false);
            mHolder=new ViewHolder();
            mHolder.tvDate= (TextView) convertView.findViewById(R.id.tvdate);
            convertView.setTag(mHolder);
        }else {
            mHolder= (ViewHolder) convertView.getTag();
        }
        MyDate date=list.get(position);
        mHolder.tvDate.setText(date.day);

        if(date.isNowDay){
            mHolder.tvDate.setBackgroundColor(Color.parseColor("#00ff00"));
        }else {
            if(selectPos ==position){
                mHolder.tvDate.setBackgroundColor(Color.parseColor("#ff6600"));
            }else {
                mHolder.tvDate.setBackgroundColor(Color.parseColor("#fefefe"));
            }
        }




//        LinearLayout.LayoutParams lp= (LinearLayout.LayoutParams) mHolder.tvDate.getLayoutParams();
//        lp.width=ScreenUtil.getScreenWidth(parent.getContext());
//        lp.height=ScreenUtil.getScreenHeight(parent.getContext());
//        mHolder.tvDate.setLayoutParams(lp);

        return convertView;
    }
    public static class ViewHolder{
        TextView tvDate;
    }

    public void setSelectPos(int selectPos) {
        this.selectPos = selectPos;
    }

    public void setSelectOrUnselectDrawableRes(int selectDrawableId,int unSelectDrawableId){

    }
}
