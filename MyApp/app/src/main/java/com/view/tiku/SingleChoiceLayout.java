package com.view.tiku;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2017/12/12.
 */

public class SingleChoiceLayout extends NestedScrollView {

    public SingleChoiceLayout(Context context) {
        super(context);
        init();
    }

    public SingleChoiceLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SingleChoiceLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        addView(new ChoiceLayout(getContext()));

    }


}
