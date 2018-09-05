package com.dawn.modules.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.dawn.modules.MainActivity;
import com.util.LogUtil;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.i("==开机启动=======>"+intent.getAction());
        Intent intent1=new Intent(context, MainActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
