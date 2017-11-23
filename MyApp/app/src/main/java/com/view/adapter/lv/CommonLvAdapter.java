package com.view.adapter.lv;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */

public abstract class CommonLvAdapter<T> extends BaseAdapter {
    private List<T> mDataList;

    public CommonLvAdapter(List<T> mDataList) {
        this.mDataList = mDataList;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommonViewHolder holder = CommonViewHolder.getViewHolder(convertView, parent, getItemLayoutId());
        getView(parent.getContext(), holder, mDataList.get(position), position);
        return holder.convertView;
    }


    public abstract int getItemLayoutId();

    public abstract void getView(Context context, CommonViewHolder holder, T data, int position);


}
