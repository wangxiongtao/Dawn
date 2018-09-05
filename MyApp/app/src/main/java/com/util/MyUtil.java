package com.util;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Administrator on 2018/5/24 0024.
 */

public class MyUtil {
    private static boolean showWm =true;//默认是应该显示悬浮通知栏

    public static void createFloatView(Context context,View view,String str) {
        WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(
                Context.WINDOW_SERVICE);
        WindowManager.LayoutParams params  = new WindowManager.LayoutParams();
        //注意是TYPE_SYSTEM_ERROR而不是TYPE_SYSTEM_ALERT
        //前面有SYSTEM才可以遮挡状态栏，不然的话只能在状态栏下显示通知栏
//        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        params.format = PixelFormat.TRANSPARENT;
        //设置必须触摸通知栏才可以关掉
        params.flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_FULLSCREEN
                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;

        // 设置通知栏的长和宽
        params.width = wm.getDefaultDisplay().getWidth();
        params.height = 200;
        params.gravity = Gravity.TOP;

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
                        break;
                    case MotionEvent.ACTION_MOVE:

                        break;
                }
                return true;
            }
        });

    }
}
