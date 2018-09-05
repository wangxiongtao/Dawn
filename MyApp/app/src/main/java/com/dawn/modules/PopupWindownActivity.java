package com.dawn.modules;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dawn.R;
import com.util.LogUtil;
import com.util.ToastUtil;
import com.view.MyPop;

public class PopupWindownActivity extends AppCompatActivity {
    private MyPop pop;
    private Button button;
    private Button button2;
    private Button button3;
    private TextView tv;
    private LinearLayout ll;
    private ScrollView scrollView;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_windown);
        scrollView=findViewById(R.id.scrollView);
        button=findViewById(R.id.show_pop);
        button2=findViewById(R.id.show_bottom);
        ll=findViewById(R.id.ll);
        button3=findViewById(R.id.btn);
        tv=findViewById(R.id.tv);
        pop=new MyPop(this);
        dialog=new ProgressDialog(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                pop.showAsDropDown(button);\
                dialog.show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(v.getContext(),"button2------button2");
            }
        });
//        ll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showShort(v.getContext(),"我是父布局");
//            }
//        });
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showShort(v.getContext(),"我是button");
//            }
//        });
//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showShort(v.getContext(),"我是Textview");
//            }
//        });
        scrollView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(v.getContext(),"我是scrollview");
            }
        });
        scrollView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ToastUtil.showShort(v.getContext(),"onLongClick我是scrollview");
                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.i("===onStart====>");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.i("===onResume====>");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.i("===onPause====>");
    }
    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.i("===onStop====>");
    }


}
