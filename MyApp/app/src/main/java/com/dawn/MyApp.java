package com.dawn;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.umeng.commonsdk.UMConfigure;
import com.util.LogUtil;

/**
 * Created by Administrator on 2017/10/18.
 */

public class MyApp extends Application {
    public static Context applicationContext;
    public static int i=0;
    @Override
    public void onCreate() {
        super.onCreate();
        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext()))) {
            i++;
            LogUtil.i("=Application=i====>"+i);
            UMConfigure.setLogEnabled(true);
            //初始化组件化基础库, 统计SDK/推送SDK/分享SDK都必须调用此初始化接口
            UMConfigure.init(this,UMConfigure.DEVICE_TYPE_PHONE,null);


        }
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                LogUtil.i("===Application==onActivityResumed=======>"+activity);
                applicationContext=activity;



            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

}
