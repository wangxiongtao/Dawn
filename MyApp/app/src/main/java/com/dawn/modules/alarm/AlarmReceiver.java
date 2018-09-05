package com.dawn.modules.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.util.LogUtil;

/**
 * Created by Administrator on 2018/5/21 0021.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.i("===onReceive========>");
        Intent i = new Intent(context, LongRunningService.class);

        context.startService(i);
    }
}
