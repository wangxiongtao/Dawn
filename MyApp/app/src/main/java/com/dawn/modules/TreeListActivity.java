package com.dawn.modules;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.dawn.R;
import com.dawn.bean.TreeBean;
import com.dawn.modules.adapter.TreeAdapter;

import java.util.ArrayList;
import java.util.List;

public class TreeListActivity extends AppCompatActivity {
    private ListView listView;
    private List<TreeBean>beanList;
    private TreeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_list);
        listView=findViewById(R.id.three_list);
        beanList=new ArrayList<>();
        adapter=new TreeAdapter(beanList);
        listView.setAdapter(adapter);
        initData();
        adapter.notifyDataSetChanged();
    }


    private void initData(){
        TreeBean bean=new TreeBean("我是一级",0,0,1);
        TreeBean bean2=new TreeBean("我是二级",1,1,2);
        TreeBean bean3=new TreeBean("我是三级",2,2,3);
        beanList.add(bean);
        beanList.add(bean2);
        beanList.add(bean3);
//        beanList.add(bean);
//        beanList.add(bean2);
//        beanList.add(bean3);
    }
}
