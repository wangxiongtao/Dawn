package com.util;

import android.content.DialogInterface;

import com.dawn.MyApp;
import com.view.dialog.EditextDialog;

/**
 * Created by Administrator on 2018/5/21 0021.
 */

public class DialogUtil {
    public static EditextDialog dialog;
    public static void showDialog(){
        if(dialog==null){
            dialog=new EditextDialog(MyApp.applicationContext);
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog1) {
                dialog=null;
            }
        });
        dialog.showDialog();

    }
}
