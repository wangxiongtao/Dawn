package com.dawn.modules;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.dawn.MyApp;
import com.util.LogUtil;

public class DialogService extends Service {
    ProgressDialog dialog;

    public DialogService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (dialog == null) {
            dialog = new ProgressDialog(MyApp.applicationContext);
            dialog.setTitle("TITLE");
        }
        dialog.show();
        LogUtil.i("======onStartCommand======>");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dialog.dismiss();
    }
}
