package com.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dawn.R;

/**
 * Created by Administrator on 2017/10/30.
 */

public class MyBottomView extends RadioGroup {
    public MyBottomView(Context context) {
        super(context);
        init(context);
    }

    public MyBottomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context){
      setOrientation(HORIZONTAL);
      for (int i=0;i<4;i++){
          addView(getRadioButton());
      }
    }


    private RadioButton getRadioButton(){
        RadioButton button=new RadioButton(this.getContext());
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1.0f);
        button.setGravity(Gravity.CENTER);
        button.setLayoutParams(lp);
        button.setButtonDrawable(null);
        Drawable d= ContextCompat.getDrawable(this.getContext(),R.drawable.ic_launcher);
        button.setCompoundDrawables(null,d,null,null);
        button.setText("TEST");
        return button;
    }
}
