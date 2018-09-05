package com.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.dawn.R;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class PopDialog extends Dialog {
    public PopDialog(@NonNull Context context) {
        super(context, R.style.ShareDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_pop);


    }

    @Override
    public void show() {
        super.show();

    }
}
