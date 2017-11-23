package com.dawn.modules;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.dawn.R;
import com.dawn.base.BaseActivity;
import com.dawn.modules.adapter.LvAdapter;
import com.dawn.modules.adapter.RvAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommonLvActivity extends BaseActivity {
    LvAdapter adapter;
    RvAdapter adapter1;
    ListView lv;
    RecyclerView rv;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_common_lv;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        lv=findViewById(R.id.lv);
        rv=findViewById(R.id.rv);
        List<String>list=new ArrayList<>();
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        list.add("ddd");
        adapter=new LvAdapter(list);
        lv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter1=new RvAdapter(list);
        rv.setAdapter(adapter1);


    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }
}
