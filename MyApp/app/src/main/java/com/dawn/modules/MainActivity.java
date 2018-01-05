package com.dawn.modules;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.fingerprint.FingerprintManager;
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

import com.dawn.R;
import com.dawn.base.BaseActivity;
import com.dawn.domain.mananger.BroadcastManager;
import com.dawn.http.request.MyRequest;
import com.dawn.modules.Fingerprint.MyIntentService;
import com.dawn.test.MyHandler;
import com.util.LogUtil;
import com.util.StatusBarUtils;
import com.util.ToastUtil;
import com.view.BottomTabView;
import com.view.NewToast;
import com.view.SDCardUtil;
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
    private FingerprintManager fingerprintManager;
    private int a=0;
    private MyHandler handler=new MyHandler(){
        @Override
        public void handlerMessage() {
            super.handlerMessage();
            Log.i("aaa","===--------------------------------------====>handlerMessage");

        }
    };
    EditText editText;
    private NewToast toast;


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
        LogUtil.i("==SDCARD  SIZE=================>"+ SDCardUtil.getMaxSDSpace(this));
        LogUtil.i("==SDCARD  A SIZE=================>"+ SDCardUtil.getAvailableSdSpace(this));
        LogUtil.i("==PHONE  SIZE=================>"+ SDCardUtil.getMaxRomSpace(this));
        LogUtil.i("==PHONE  A SIZE=================>"+ SDCardUtil.getAvailableRomSpace(this));
        LogUtil.i("==getPackageCodePath=================>"+getPackageCodePath());
        StatusBarUtils.transparencyBar(this);
        StatusBarUtils.statusBarDarkMode(this);

        Messenger messenger=new Messenger(new Handler());
        Message message=new Message();
         toast=new NewToast();
//        fingerprintManager=getSystemService(FingerprintManager.class);
//        FingerUtil.init();
//        Window window=getWindow();
//        TextView tv=new TextView(this);
//        tv.setText("saddasdas");
//        tv.setTextColor(Color.parseColor("#ff6600"));
//        window.setContentView(tv,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200));
//        WindowManager m=getWindowManager();
//        TextView tv2=new TextView(this);
//        tv2.setText("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
//        tv2.setTextColor(Color.parseColor("#ff6600"));
//        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                0, 0,
//                PixelFormat.TRANSPARENT
//        );
//        layoutParams.type=WindowManager.LayoutParams.TYPE_TOAST;
//        m.addView(tv2,layoutParams);







//        Log.i("aaa","==========encrypt====>"+ NativeUtil.myEncrypt(""));
//        Log.i("aaa","==========decrypt====>"+ NativeUtil.myDecrypt(""));
    }
    public  void fun(){
        Log.i("aaa","=======getRootDirectory============>fun"+ Environment.getRootDirectory());
        Log.i("aaa","=======getExternalStorageDirectory============>fun"+ Environment.getExternalStorageDirectory());
        Log.i("aaa","=======getExternalFilesDir============>fun"+getExternalFilesDir("test/b/c/qwe"));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        MyFingerPrintManager.getInstance().startListening(this);
//        fingerprintManager.authenticate(new FingerprintManager.CryptoObject(FingerUtil.defaultCipher),new CancellationSignal(), 0,new FingerprintManager.AuthenticationCallback()
//        {
//            @Override
//            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
//                super.onAuthenticationSucceeded(result);
//                ToastUtil.showShort(MainActivity.this,"指纹成功");
//            }
//
//            @Override
//            public void onAuthenticationError(int errorCode, CharSequence errString) {
//                super.onAuthenticationError(errorCode, errString);
//                ToastUtil.showShort(MainActivity.this,"指纹错误--"+errString);
//            }
//
//            @Override
//            public void onAuthenticationFailed() {
//                super.onAuthenticationFailed();
//                ToastUtil.showShort(MainActivity.this,"指纹失败--");
//            }
//        },null);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
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
//                Toast.makeText(button.getContext(),button.getText().toString()+postion,0).show();
//                ToastUtil.myToast(getApplicationContext());

                toast.init(getApplicationContext(),R.style.CouponDialogAnimation);

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
//                    new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        handler.sendMessage();
//                    }
//                }).start();
//                    handler.loop();
                    Intent i=new Intent(view.getContext(), MyIntentService.class);
                    startService(i);
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
                case 6:
                    intent.setClass(parent.getContext(),ServiceTestActivity.class);
                    ToastUtil.showShort(MainActivity.this,"hint"+(a++));

//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 7:
                    intent.setClass(parent.getContext(),QRCodeActivity.class);
                    ToastUtil.showShort(MainActivity.this,"hint"+(a++));

//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 8:
                    intent.setClass(parent.getContext(),MyViewActivity.class);
                    ToastUtil.showShort(MainActivity.this,"hint"+(a++));

//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 9:
                    intent.setClass(parent.getContext(),WebViewActivity.class);
                    ToastUtil.showShort(MainActivity.this,"hint"+(a++));

//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 10:
                    intent.setClass(parent.getContext(),TreeListActivity.class);
                    ToastUtil.showShort(MainActivity.this,"hint"+(a++));

//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 11:
                    intent.setClass(parent.getContext(),TiKuActivity.class);
                    ToastUtil.showShort(MainActivity.this,"hint"+(a++));

//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 12:
                    intent.setClass(parent.getContext(),ViewPagerActivity.class);
                    ToastUtil.showShort(MainActivity.this,"hint"+(a++));

//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
            }
            startActivityForResult(intent,0);
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
        adapter.add("service");
        adapter.add("Zxing");
        adapter.add("自定义View");
        adapter.add("webview");
        adapter.add("多级列表");
        adapter.add("题库");
        adapter.add("viewpager");
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

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ToastUtil.showShort(this,"width========="+lv.getWidth()+"");
    }
}
