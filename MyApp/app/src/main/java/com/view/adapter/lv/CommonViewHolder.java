package com.view.adapter.lv;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/11/15.
 */

public class CommonViewHolder {
    public View convertView;
    private SparseArray<View>viewArray;

     private CommonViewHolder(ViewGroup parent,int layoutId){
        convertView= LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        convertView.setTag(this);
        viewArray=new SparseArray<>();

    }
     static CommonViewHolder getViewHolder(View convertView,ViewGroup parent,int layoutId){
        if(convertView==null){
            return new CommonViewHolder(parent,layoutId);
        }else {
            return (CommonViewHolder) convertView.getTag();
        }
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
