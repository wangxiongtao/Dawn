package com.view.adapter.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */

public abstract class CommonRvAdapter<T> extends RecyclerView.Adapter<CommonRvViewHolder> {
    public CommonRvAdapter(List<T> mDataList) {
        this.mDataList = mDataList;
    }

    private List<T> mDataList;

    @Override
    public CommonRvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(getItemLayoutId(), parent,false);
//        View v=View.inflate(parent.getContext(),getItemLayoutId(),null);
        return new CommonRvViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CommonRvViewHolder holder, int position) {
        onBindViewHolder(holder.itemView.getContext(), holder, mDataList.get(position), position);

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public abstract int getItemLayoutId();

    public abstract void onBindViewHolder(Context context, CommonRvViewHolder holder, T data, int position);
}
