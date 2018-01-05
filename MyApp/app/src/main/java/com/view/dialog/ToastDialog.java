package com.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;

import com.dawn.R;
import com.view.toast.ToastAnimationView;

/**
 * Created by Administrator on 2017/12/12.
 */

public class ToastDialog extends Dialog {
    private ToastAnimationView toast;
    public ToastDialog(@NonNull Context context) {
        super(context,R.style.ShareDialog);
        init();
    }

    private void init(){
        View view=View.inflate(getContext(), R.layout.toast_wide,null);
        toast=view.findViewById(R.id.toast1);
        setContentView(view);
        Window dialogWindow =getWindow();
        if(dialogWindow!=null){
            dialogWindow.setGravity(Gravity.TOP);
        }
    }
    public void showDialog(){
        if(!isShowing()){
            show();
            toast.showAnimaToast();
        }
    }



}
