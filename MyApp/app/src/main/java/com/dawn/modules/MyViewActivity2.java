package com.dawn.modules;

import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.dawn.R;
import com.util.LogUtil;
import com.view.InputPwdLayout;
import com.view.InputPwdView;

public class MyViewActivity2 extends AppCompatActivity {
    private InputPwdView pwdView;
    private InputPwdLayout input_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view2);
        pwdView=findViewById(R.id.input_view);
        input_layout=findViewById(R.id.input_layout);
        LinearLayout.LayoutParams lp= (LinearLayout.LayoutParams) pwdView.getLayoutParams();
        LogUtil.i("====w======>"+lp.width);
        LogUtil.i("====h======>"+lp.height);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                LogUtil.i("====h2======>"+input_layout.getHeight());
                return false;
            }
        });



//        EditextDialog dialog=new EditextDialog(this);
//        dialog.showDialog();
    }
}
