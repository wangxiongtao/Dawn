package com.view.toast;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/12/12.
 */

public class MyToast {
    private ToastAnimationView mView;
    private ViewGroup mParentView;
    private boolean mIsAttach;
    public MyToast(Context context){

        mView = new ToastAnimationView(context);
        mParentView = (ViewGroup) ((Activity) context).getWindow().getDecorView();
    }

    public void attach(){
        mView.setText("dsadsaduiashdiuijsajd");
        if(!mIsAttach){
            mView.setGravity(Gravity.CENTER);
            mView.setBackgroundColor(Color.parseColor("#ff6600"));
            mParentView.addView(mView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mIsAttach=true;
        }

        mView.showAnimaToast();
    }


}
