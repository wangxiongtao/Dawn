package com.view.adapter.rv;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by Administrator on 2017/11/15.
 */

public class CommonRvViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> viewArray;
    private View convertView;

    public CommonRvViewHolder(View itemView) {
        super(itemView);
        viewArray=new SparseArray<>();
        convertView=itemView;
    }
    public < T extends  View> T getViewById(int id){
        View v=viewArray.get(id);
        if(v==null){
            v=convertView.findViewById(id);
            viewArray.append(id,v);
        }
        return (T)v;
    }
}
