package com.dawn.modules;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dawn.R;
import com.view.MyViewGroup;
import com.view.toast.ToastAnimationView;

import java.util.ArrayList;
import java.util.List;

public class MyViewActivity extends AppCompatActivity {
    MyViewGroup myViewGroup;
    private List<View> viewList = new ArrayList<>();
    private ToastAnimationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);
        myViewGroup = findViewById(R.id.viewgroup);
        view=findViewById(R.id.toast);
//        for (int i = 0; i < 20; i++) {
//            TextView tv = new TextView(this);
//            tv.setBackgroundColor(Color.parseColor("#ff6600"));
//            tv.setText("sdqweqwedqw" + i);
//
//            viewList.add(tv);
//        }
//        myViewGroup.addViewList(viewList);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.showAnimaToast();
            }
        });

    }

}
