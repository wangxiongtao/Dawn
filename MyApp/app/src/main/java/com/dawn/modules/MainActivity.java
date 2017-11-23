package com.dawn.modules;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.dawn.R;
import com.dawn.base.BaseActivity;
import com.dawn.domain.mananger.BroadcastManager;
import com.dawn.http.request.MyRequest;
import com.dawn.test.MyHandler;
import com.util.LogUtil;
import com.util.StatusBarUtils;
import com.util.ToastUtil;
import com.view.BottomTabView;
import com.view.ToDaysDialog;

import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

/**
 * 这是注释注释注释注释注释注释注释注释
 * 测试测试测试的是测试测试
 *
 */

class B{
    public void fun(){
        System.out.println("==fun b=============>");
    };
    private void fun2(){
        System.out.println("==fun b=============>");
    };
    protected void fun3(){
        System.out.println("==fun b=============>");
    };
}
class C extends B{
    @Override
    public void fun() {
        System.out.println("==fun c============>");
    }
    public void fun1() {
        System.out.println("==fun1 c============>");
    }

}



public class MainActivity extends BaseActivity implements Observer {
    ToDaysDialog daysDialog;
    private ListView lv;
    private RadioButton radioButton;
    private BottomTabView bottomView;
    private MyHandler handler=new MyHandler(){
        @Override
        public void handlerMessage() {
            super.handlerMessage();
            Log.i("aaa","===--------------------------------------====>handlerMessage");

        }
    };
    EditText editText;


    @Override
    protected void beforeOnCreate() {

    }

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
        B b=new C();
        b.fun();
//        mToolbar_Title_Txt.setText("测试");
        lv= (ListView) findViewById(R.id.lv);
        radioButton=  findViewById(R.id.rbtn);
        bottomView=  findViewById(R.id.bottom);
        Drawable d= ContextCompat.getDrawable(this,R.drawable.ic_launcher);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(null,d,null,null);
        radioButton.setText("TEST");
        editText=findViewById(R.id.ed);
        Thread thread=new Thread(new MyRunable(this));
        thread.start();

        int[] colors = new int[]{ContextCompat.getColor(this,R.color.colorAccent), ContextCompat.getColor(this,R.color.colorPrimaryDark)};

        int[][] states = new int[2][];

        states[0] = new int[]{-android.R.attr.state_checked};
        states[1] = new int[]{android.R.attr.state_checked};


        ColorStateList colorStateList = new ColorStateList(states, colors);
        radioButton.setTextColor(colorStateList);
        LogUtil.i("==getPackageResourcePath=================>"+getPackageResourcePath());
        LogUtil.i("==getPackageCodePath=================>"+getPackageCodePath());
        StatusBarUtils.transparencyBar(this);
        StatusBarUtils.statusBarDarkMode(this);

        Messenger messenger=new Messenger(new Handler());
        Message message=new Message();






//        Log.i("aaa","==========encrypt====>"+ NativeUtil.myEncrypt(""));
//        Log.i("aaa","==========decrypt====>"+ NativeUtil.myDecrypt(""));
    }
    public  void fun(){
        Log.i("aaa","=======getRootDirectory============>fun"+ Environment.getRootDirectory());
        Log.i("aaa","=======getExternalStorageDirectory============>fun"+ Environment.getExternalStorageDirectory());
        Log.i("aaa","=======getExternalFilesDir============>fun"+getExternalFilesDir("test/b/c/qwe"));
    }

    @Override
    public void update(Observable o, Object arg) {

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

        /**
         *
         */
//        mToolbar_Title_Txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"click",0).show();
//            }
//        });
        bottomView.setOnTabItemSelectListener(new BottomTabView.OnTabItemSelectListener() {
            @Override
            public void onTabItemSelect(RadioButton button, int postion) {
                Toast.makeText(button.getContext(),button.getText().toString()+postion,0).show();
            }

            @Override
            public void f() {

            }
        });





        lv.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent=new Intent();
            switch (position){

                case 0:
//                    intent.setClass(parent.getContext(),HttpActivity.class);
                    new Thread(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendMessage();
                    }
                }).start();
                    handler.loop();
//
                    break;
                case 1:
                    Log.i("aaa","=======setOnItemClickListener==1====>");
                    intent.setClass(parent.getContext(),RSAActivity.class);
                    break;
                case 2:
                    Log.i("aaa","=======setOnItemClickListener==1====>");
//                    intent.setClass(parent.getContext(),MVPActivity.class);
                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 3:
                    Log.i("aaa","=======setOnItemClickListener==1====>");
                    intent.setClass(parent.getContext(),TouchEventActivity.class);
//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 4:
                    Log.i("aaa","=======setOnItemClickListener==1====>");
                    intent.setClass(parent.getContext(),CalendarViewActivity.class);
                    lv.setItemChecked(position,true);
//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 5:
                    Log.i("aaa","=======setOnItemClickListener==1====>");
                    intent.setClass(parent.getContext(),CommonLvActivity.class);
                    ToastUtil.showShort(MainActivity.this,"hint");

//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
            }
//            startActivityForResult(intent,0);
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
        adapter.add("MVP");
        adapter.add("事件分发");
        adapter.add("自定义日历");
        adapter.add("listview");
        lv.setAdapter(adapter);


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        BroadcastManager.getInstance(this).destroy("test");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.e("=======requestCode========>"+requestCode);
        LogUtil.e("=======resultCode========>"+resultCode);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LogUtil.e("=======onBackPressed========>");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        LogUtil.e("=======onKeyDown========>");
        return super.onKeyDown(keyCode, event);
    }
}
