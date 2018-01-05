package com.dawn.modules.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dawn.R;
import com.dawn.bean.TreeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/11.
 */

public class TreeAdapter extends BaseAdapter {
    public List<TreeBean>list;
    boolean isClick=true;

    public TreeAdapter(List<TreeBean> list) {
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
        ViewHolder mHolder;
        if(convertView==null){
            mHolder=new ViewHolder();
            convertView=View.inflate(parent.getContext(), R.layout.item_lv_layout,null);
            mHolder.tv=convertView.findViewById(R.id.item_tv);
            convertView.setTag(mHolder);
        }else {
            mHolder= (ViewHolder) convertView.getTag();
        }
        TreeBean bean=list.get(position);
        mHolder.tv.setText(bean.content);
        mHolder.tv.setPadding(bean.level*50,0,0,0);
        mHolder.tv.setVisibility(bean.isVisible?View.VISIBLE:View.GONE);

        mHolder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                showChildren(!isShow,bean.id);
//                isShow=!isShow;
            }
        });




        return convertView;
    }
    class ViewHolder{
        TextView tv;
    }


    public void closeChildren(int id){
        for (int i=0;i<list.size();i++){
            TreeBean bean=list.get(i);

            if(bean.pid==id){
                bean.isVisible=false;
                closeChildren(bean.id);
                break;
            }
        }
        notifyDataSetChanged();
    }
    public void showChildren(int id){
        for (int i=0;i<list.size();i++){
            TreeBean bean=list.get(i);

            if(bean.pid==id){
                bean.isVisible=true;
                showChildren(bean.id);
                break;
            }
        }
        notifyDataSetChanged();
    }
}
