package com.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.dawn.R;
import com.view.toast.ToastAnimationView;

/**
 * Created by Administrator on 2017/12/12.
 */

public class EditextDialog extends Dialog {
    private ToastAnimationView toast;
    public EditextDialog(@NonNull Context context) {
        super(context,R.style.ShareDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        View view=View.inflate(getContext(), R.layout.dialog_edittext_layout,null);

        setContentView( R.layout.dialog_edittext_layout);
    }

    public void showDialog(){
        if(!isShowing()){
            show();

        }
    }



}
