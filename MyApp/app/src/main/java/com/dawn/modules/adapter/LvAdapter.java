package com.dawn.modules.adapter;

import android.content.Context;
import android.widget.TextView;

import com.dawn.R;
import com.view.adapter.lv.CommonLvAdapter;
import com.view.adapter.lv.CommonViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */

public class LvAdapter extends CommonLvAdapter<String> {


    public LvAdapter(List<String> mDataList) {
        super(mDataList);
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_lv_layout;
    }

    @Override
    public void getView(Context context, CommonViewHolder holder, String data, int position) {
        TextView tv=holder.getViewById(R.id.item_tv);
        tv.setText(data);
    }


}
