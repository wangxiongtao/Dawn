package com.dawn.modules;

import android.content.Context;
import android.graphics.PixelFormat;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.dawn.R;
import com.dawn.base.BaseActivity;
import com.util.DialogUtil;

import org.greenrobot.eventbus.EventBus;

public class UmengActivity extends BaseActivity {
    private Ringtone r;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_umeng;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        String uri = "android.resource://" + getPackageName() + "/"+R.raw.neworder;
        Uri no=Uri.parse(uri);
        r = RingtoneManager.getRingtone(getApplicationContext(), no);
        initWindowManager();

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }
    public void onClick(View v){
        DialogUtil.showDialog();


//        MobclickAgent.onEvent(v.getContext().getApplicationContext(),"TEST");
//        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        Notification notification = builder
//                .setContentTitle("这是通知标题")
//                .setContentText("这是通知内容")
//                .setFullScreenIntent(null, false)
//                .setWhen(System.currentTimeMillis())
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setPriority(Notification.PRIORITY_MAX)//可以让通知显示在最上面
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
//                .build();
//        manager.notify(1, notification);
//
//
//
//        if(!r.isPlaying()){
//            r.play();
//
//        }



//       createFloatView("");

//        WindowManager.LayoutParams wl = new WindowManager.LayoutParams();
//        wl.type= WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
//        wl.flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
//                | WindowManager.LayoutParams.FLAG_FULLSCREEN
//                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
//        wl.gravity=Gravity.TOP;
//        wl.height = 200;
//        wl.width = WindowManager.LayoutParams.MATCH_PARENT;
//        TextView tv=new TextView(this);
//        tv.setBackgroundColor(Color.parseColor("#ff6600"));
//        tv.setText("通知");
//        getWindowManager().addView(tv, wl);
//        tv.setOnTouchListener(new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction())
//                {
//                    case MotionEvent.ACTION_DOWN:
//                        wm.removeViewImmediate(tv);
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//
//                        break;
//                }
//                return true;
//            }
//        });



    }
    public void onClick1(View v){
//        int a=1/0;

        EventBus.getDefault().postSticky("dsadasdada");
        finish();
    }
    private View view;
    private WindowManager wm;
    private boolean showWm =true;//默认是应该显示悬浮通知栏
    private WindowManager.LayoutParams params;

    private void initWindowManager(){
        wm = (WindowManager) getApplicationContext().getSystemService(
                Context.WINDOW_SERVICE);
        params  = new WindowManager.LayoutParams();
        //注意是TYPE_SYSTEM_ERROR而不是TYPE_SYSTEM_ALERT
        //前面有SYSTEM才可以遮挡状态栏，不然的话只能在状态栏下显示通知栏
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        params.format = PixelFormat.TRANSPARENT;
        //设置必须触摸通知栏才可以关掉
        params.flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_FULLSCREEN
                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;

        // 设置通知栏的长和宽
        params.width = wm.getDefaultDisplay().getWidth();
        params.height = 200;
        params.gravity = Gravity.TOP;

    }


    private void createFloatView(String str) {

        view = LayoutInflater.from(this).inflate(R.layout.wechat, null);
        //在这里你可以解析你的自定义的布局成一个View
        if (showWm){
            wm.addView(view, params);
            showWm = false;
        }else {
            wm.updateViewLayout(view,params);
        }


        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        wm.removeViewImmediate(view);
                        view = null;
                        break;
                    case MotionEvent.ACTION_MOVE:

                        break;
                }
                return true;
            }
        });

    }



    public static void playSound(Context context,int rawId) {
        SoundPool soundPool;
        if (Build.VERSION.SDK_INT >= 21) {
            SoundPool.Builder builder = new SoundPool.Builder();
            //传入音频的数量
            builder.setMaxStreams(1);
            //AudioAttributes是一个封装音频各种属性的类
            AudioAttributes.Builder attrBuilder = new AudioAttributes.Builder();
            //设置音频流的合适属性
            attrBuilder.setLegacyStreamType(AudioManager.STREAM_MUSIC);
            builder.setAudioAttributes(attrBuilder.build());
            soundPool = builder.build();
        } else {
            //第一个参数是可以支持的声音数量，第二个是声音类型，第三个是声音品质
            soundPool = new SoundPool(1, AudioManager.STREAM_SYSTEM, 5);
        }
        //第一个参数Context,第二个参数资源Id，第三个参数优先级
        soundPool.load(context, rawId, 1);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(final SoundPool soundPool, int sampleId, int status) {
                soundPool.play(1, 1, 1, 0, 0, 1);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        soundPool.release();
                    }
                },1000);
            }
        });
        //第一个参数id，即传入池中的顺序，第二个和第三个参数为左右声道，第四个参数为优先级，第五个是否循环播放，0不循环，-1循环
        //最后一个参数播放比率，范围0.5到2，通常为1表示正常播放
//        soundPool.play(1, 1, 1, 0, 0, 1);
        //回收Pool中的资源
        //soundPool.release();

    }

}
