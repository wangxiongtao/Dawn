package com.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dawn.R;
import com.util.LogUtil;
import com.util.ScreenUtil;

/**
 * Created by Administrator on 2017/10/30.
 */

public class BottomTabView extends RadioGroup {
    private ColorStateList colorStateList;
    private int width;
    private LinearLayout.LayoutParams lp;
    private OnTabItemSelectListener listener;
    private int iconResId;
    private CharSequence[] texts;
    private Color selectColor;
    private Color unSelectColor;

    public BottomTabView(Context context) {
        super(context);
        init(context);
        LogUtil.i("===BottomTabView 一个参数======>");
    }

    public BottomTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BottomTabView);
        iconResId = a.getResourceId(R.styleable.BottomTabView_tab_icon, 0);
        texts = a.getTextArray(R.styleable.BottomTabView_tab_text);
        int selectColorId = a.getResourceId(R.styleable.BottomTabView_tab_textSelectColor, 0);
        int unSelectColorId = a.getResourceId(R.styleable.BottomTabView_tab_textUnSelectColor, 0);
//        CharSequence array[]=a.getTextArray(R.styleable.BottomTabView_myIcon);
        LogUtil.i("===BottomTabView====iconResId=======>" + iconResId);
        a.recycle();


        int[] colors = new int[]{ContextCompat.getColor(getContext(), unSelectColorId), ContextCompat.getColor(getContext(), selectColorId)};

        int[][] states = new int[2][];

        states[0] = new int[]{-android.R.attr.state_checked};
        states[1] = new int[]{android.R.attr.state_checked};

        colorStateList = new ColorStateList(states, colors);


        init(context);
        RadioButton button = (RadioButton) getChildAt(0);
        button.setChecked(true);
    }

    private void init(Context context) {
        setOrientation(HORIZONTAL);
        width = ScreenUtil.getScreenWidth(context) / 4;
        TypedArray ar = getResources().obtainTypedArray(iconResId);
        lp = new LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT);
        for (int i = 0; i < 4; i++) {
            RadioButton button = getRadioButton();
            Drawable d = getResources().getDrawable(ar.getResourceId(i, 0));
            button.setCompoundDrawablesWithIntrinsicBounds(null, d, null, null);
            button.setText(texts[i]);
            button.setTextColor(colorStateList);
            int finalI = i;
            button.setOnClickListener((view) ->
                    {
                        if (listener != null) {
                            listener.onTabItemSelect(button, finalI);
                        }
                    }


            );
            addView(button);
        }
        ar.recycle();
    }


    private RadioButton getRadioButton() {
        RadioButton button = new RadioButton(this.getContext());
        button.setGravity(Gravity.CENTER);
        button.setLayoutParams(lp);
        button.setButtonDrawable(null);
        return button;
    }

    public interface OnTabItemSelectListener {
        void onTabItemSelect(RadioButton button, int postion);
        void f();
    }

    public void setOnTabItemSelectListener(OnTabItemSelectListener listener) {
        this.listener = listener;
    }
}
