package com.view;

import android.content.Context;
import android.view.View;

import com.dawn.R;
import com.util.ToastUtil;

/**
 * Created by Administrator on 2018/5/22 0022.
 */

public class MyPop extends BasePopupWindow {
    public MyPop(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.my_pop;
    }

    @Override
    public void createView(View contentView) {
        getPopupWindow().getContentView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showShort(v.getContext(),"click");
            }
        });
//        getPopupWindow().getContentView().setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                ToastUtil.showShort(v.getContext(),"onTouch");
//                return false;
//            }
//        });
//        ScrollView s=contentView.findViewById(R.id.sc);
//        s.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showShort(v.getContext(),"click");
//            }
//        });

    }
}
