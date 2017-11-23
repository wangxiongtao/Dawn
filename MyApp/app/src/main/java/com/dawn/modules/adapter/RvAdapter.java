package com.dawn.modules.adapter;

import android.content.Context;

import com.dawn.R;
import com.view.adapter.rv.CommonRvAdapter;
import com.view.adapter.rv.CommonRvViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */

public class RvAdapter extends CommonRvAdapter<String> {
    public RvAdapter(List<String> mDataList) {
            super(mDataList);
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_lv_layout;
    }

    @Override
    public void onBindViewHolder(Context context, CommonRvViewHolder holder, String data, int position) {

    }
}
