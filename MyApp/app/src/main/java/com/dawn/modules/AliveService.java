package com.dawn.modules;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.util.ToastUtil;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AliveService extends Service {
    private int a=0;
    AtomicInteger integer=new AtomicInteger(0);
    ThreadLocal<Integer>threadLocal=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    HashMap<Thread,Integer>map=new HashMap<>();
    public AliveService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        ToastUtil.showShort(this,"啊 我被bind了");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        ToastUtil.showShort(this,"啊 我被onUnbind了");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//        AlertDialog.Builder b=new AlertDialog.Builder(this);
//        b.setMessage("我是对话框").show();
        ToastUtil.showShort(this,"startid"+startId);
//        Intent intent1=new Intent(this,MVPActivity.class);
//        startActivity(intent1);


//        startForeground(1001, new Notification());
//        stopSelf();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
////                        int a=threadLocal.get();
////                        a++;
////                        threadLocal.set(a);
////                    Integer a=map.get(Thread.currentThread());
////                    if(a==null){
////                        a=0;
////                    }
//                    a++;
////                    map.put(Thread.currentThread(),a);
//
////                    integer.getAndIncrement();
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        LogUtil.i("线程名字=="+Thread.currentThread().getName()+"===========a===============>"+a);
//                    }
//            }
//        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        ToastUtil.showShort(this,"啊 我被onDestroy了");
    }
    public class MyBinder extends Binder {

        public AliveService getService(){
            return AliveService.this;
        }
    }
}
