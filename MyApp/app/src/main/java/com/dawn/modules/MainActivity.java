package com.dawn.modules;

import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.PersistableBundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.dawn.MyApp;
import com.dawn.R;
import com.dawn.base.BaseActivity;
import com.dawn.domain.mananger.BroadcastManager;
import com.dawn.http.request.MyRequest;
import com.dawn.modules.Fingerprint.MyIntentService;
import com.dawn.modules.alarm.AlarmManagerActivity;
import com.dawn.modules.fragmenttest.TestActivity;
import com.dawn.modules.notkillservice.NotKillActivity;
import com.dawn.modules.workmanager.WorkManagerActivity;
import com.dawn.test.MyHandler;
import com.util.Argb8888Transform;
import com.util.ImageUtil;
import com.util.LogUtil;
import com.util.StatusBarUtils;
import com.util.ToastUtil;
import com.view.AutoSplitTextView;
import com.view.BottomTabView;
import com.view.ImagePicker.ImagePickerActivity;
import com.view.NameTextView;
import com.view.NewToast;
import com.view.SDCardUtil;
import com.view.TextFlickerView;
import com.view.ToDaysDialog;
import com.view.ToImageActivity;

import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

/**
 * 这是注释注释注释注释注释注释注释注释
 * 测试测试测试的是测试测试
 *
 */

class B{
    public void fun(){
        System.out.println("==animationEnd b=============>");
    };
    private void fun2(){
        System.out.println("==animationEnd b=============>");
    };
    protected void fun3(){
        System.out.println("==animationEnd b=============>");
    };
}
class C extends B{
    @Override
    public void fun() {
        System.out.println("==animationEnd c===MyApp.i=========>"+ MyApp.i++);
    }
    public void fun1() {
        System.out.println("==fun1 c============>");
    }

}



public  class MainActivity extends BaseActivity implements Observer {
    ToDaysDialog daysDialog;
    ProgressDialog dialog;
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
    private ImageView imageView;
    private ImageView imageView2;
    private String imgurl="http://img.quanshishequ.com/group1/M00/00/A1/Cns0v1rVnN6AZw6XAABXHovNhaw264.jpg";
    TextFlickerView textFlickerView;
    private TextView tvAddr;
    private NameTextView tvAddr2;
    private AutoSplitTextView tvAddr3;


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
        LogUtil.i("==MainActivity==taskId===>"+getTaskId());
        B b=new C();
        b.fun();
        dialog=new ProgressDialog(this,R.style.common_dialog);
        dialog.show();
//        mToolbar_Title_Txt.setText("测试");
        lv= (ListView) findViewById(R.id.lv);
        radioButton=  findViewById(R.id.rbtn);
        bottomView=  findViewById(R.id.bottom);
        textFlickerView=  findViewById(R.id.text);
        tvAddr=  findViewById(R.id.order_detail_address_tv);
        Drawable d= ContextCompat.getDrawable(this,R.drawable.ic_launcher);
        radioButton.setCompoundDrawablesWithIntrinsicBounds(null,d,null,null);
        radioButton.setText("TEST");
        editText=findViewById(R.id.ed);
        imageView=findViewById(R.id.test_image);
        imageView2=findViewById(R.id.test_image2);
        tvAddr2=findViewById(R.id.order_detail_address_tv2);
        tvAddr3=findViewById(R.id.order_detail_address_tv3);
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
        TimePickerDialog dialog=new TimePickerDialog(this, R.style.common_time_dialog, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }
        }, Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE),
                true);
//        dialog.show();
        textFlickerView.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ToastUtil.show(MainActivity.this,"tus",0);
            }
        },6000);

//        tvAddr.setText("收货地址：" +ToDBC("北京市高和萃北京市朝阳区东三环北路甲26号楼博瑞大厦"));
        String s="收货地址北京市高和萃北京市朝阳区东三环北路甲号楼博瑞大厦博瑞大厦博瑞大厦东三环北路甲号东三环北路甲号";
        String s1="收货地址北京市高和萃北202";
        tvAddr2.setText(s1);
        tvAddr3.setText(s);
        tvAddr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvAddr2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

            }
        });


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

        Glide.with(this).load(imgurl).transform(new Argb8888Transform(this)).into(imageView2);
        Glide.with(this).load(imgurl).into(imageView);
//        loadImage(this,imgurl,imageView2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap= ImageUtil.getImageBitmap(imgurl);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();










//        Log.i("aaa","==========encrypt====>"+ NativeUtil.myEncrypt(""));
//        Log.i("aaa","==========decrypt====>"+ NativeUtil.myDecrypt(""));
    }
    public static String ToDBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);

            }
        }
        return new String(c);
    }
    public  void fun(){
        Log.i("aaa","=======getRootDirectory============>animationEnd"+ Environment.getRootDirectory());
        Log.i("aaa","=======getExternalStorageDirectory============>animationEnd"+ Environment.getExternalStorageDirectory());
        Log.i("aaa","=======getExternalFilesDir============>animationEnd"+getExternalFilesDir("test/b/c/qwe"));
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
        LogUtil.i("=====onPause=====>");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.i("=====onStop=====>");
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
                    intent.setClass(parent.getContext(),MVPActivity.class);
//                    startService(new Intent(parent.getContext(),AliveService.class));
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
                case 13:
                    intent.setClass(parent.getContext(),PullToRefreshActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 14:
                    intent.setClass(parent.getContext(),ShowErrorActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 15:
                    intent.setClass(parent.getContext(),MyViewActivity2.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 16:
                    intent.setClass(parent.getContext(),MyView3Activity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 17:
                    intent.setClass(parent.getContext(),MyView4Activity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 18:
                    intent.setClass(parent.getContext(),DrawerLayoutActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 19:
                    intent.setClass(parent.getContext(),AlarmManagerActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 20:
                    intent.setClass(parent.getContext(),NotKillActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 21:
                    intent.setClass(parent.getContext(),PopupWindownActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 22:
                    intent.setClass(parent.getContext(),WorkManagerActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 23:
                    intent.setClass(parent.getContext(),UmengActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 24:
                    intent.setClass(parent.getContext(),TestActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 25:
                    JobScheduler jobScheduler = (JobScheduler)getSystemService(Context.JOB_SCHEDULER_SERVICE);
                    intent.setClass(parent.getContext(),NewTaskActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 26:
                    intent.setClass(parent.getContext(),WindowActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 27:
                    intent.setClass(parent.getContext(),LooperActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 28:
                    intent.setClass(parent.getContext(),ToggleButtonActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 29:
                    intent.setClass(parent.getContext(),PlayAudioActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 30:
                    intent.setClass(parent.getContext(),RecycleViewAnimActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 31:
                    intent.setClass(parent.getContext(),ToImageActivity.class);


//                    startService(new Intent(parent.getContext(),AliveService.class));
                    break;
                case 32:
                    intent.setClass(parent.getContext(),ImagePickerActivity.class);


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
        adapter.add("pull-to-refresh");
        adapter.add("showError");
        adapter.add("自定义View2");
        adapter.add("自定义View3");
        adapter.add("自定义View4");
        adapter.add("抽屉");
        adapter.add("alarmManager");
        adapter.add("notkillservice");
        adapter.add("Popupwindow");
        adapter.add("WorkManager");
        adapter.add("友盟统计");
        adapter.add("fragment   bug");
        adapter.add("NEW TASK ACTIVITY");
        adapter.add("window ACTIVITY");
        adapter.add("轮询实现方式");
        adapter.add("toggle");
        adapter.add("播放提示音");
        adapter.add("recyclerView 动画");
        adapter.add("相册选择图片");
        adapter.add("相册选择图片-自己写的");
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
//        System.exit(0);
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

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
    }

    public  void loadImage(Context context ,String url, final ImageView imageView){

        Glide.with(context)
                .load(url)
                .centerCrop()
                .crossFade()
                .thumbnail( 0.1f )
                .into(new GlideDrawableImageViewTarget(imageView) {
                    @Override
                    public void onResourceReady(GlideDrawable drawable, GlideAnimation anim) {
                        super.onResourceReady(drawable, anim);
                        //在这里添加一些图片加载完成的操作
                        imageView.setImageDrawable(drawable);
                    }
                });
    }
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
        LogUtil.i("===onSaveInstanceState====>");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.i("===onRestoreInstanceState====>");
    }


}
