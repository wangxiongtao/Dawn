package com.dawn.modules;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.base.BaseActivity;
import com.dawn.R;
import com.dawn.domain.mananger.BroadcastManager;
import com.dawn.http.request.LoginRequest;
import com.dawn.http.request.MyRequest;
import com.view.ToDaysDialog;

import java.lang.ref.WeakReference;

public class MainActivity extends BaseActivity {
    ToDaysDialog daysDialog;
    private ListView lv;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mToolbar_Title_Txt.setText("测试");
        lv= (ListView) findViewById(R.id.lv);

        Thread thread=new Thread(new MyRunable(this));
        thread.start();


//        Log.i("aaa","==========encrypt====>"+ NativeUtil.myEncrypt(""));
//        Log.i("aaa","==========decrypt====>"+ NativeUtil.myDecrypt(""));
    }
    public  void fun(){
        Log.i("aaa","===================>fun");
    }

    static class MyRunable implements Runnable{
        private WeakReference<MainActivity> weakReference;
        public MyRunable (MainActivity activity){
            weakReference=new WeakReference<MainActivity>(activity);
        }
        @Override
        public void run() {
            weakReference.get().fun();
        }
    }

    @Override
    protected void setListener() {
//        mToolbar_Title_Txt.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
        mToolbar_Title_Txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"click",0).show();
            }
        });




        lv.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent=new Intent();
            switch (position){

                case 0:
                    intent.setClass(parent.getContext(),HttpActivity.class);
//
                    break;
                case 1:
                    Log.i("aaa","=======setOnItemClickListener==1====>");
                    intent.setClass(parent.getContext(),RSAActivity.class);
                    break;
            }
            startActivity(intent);
        });
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }

    /**
     *
     */

    @Override
    protected void initData() {
        MyRequest request=new MyRequest(1);
        request.id="wo s id";
        request.name="wo s name";

        BroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                mToolbar_Title_Txt.setText("收到广播了");
            }
        },"test");

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.add("测试网络框架");
        adapter.add("RSA加密");
        lv.setAdapter(adapter);


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        BroadcastManager.getInstance(this).destroy("test");
    }
}
