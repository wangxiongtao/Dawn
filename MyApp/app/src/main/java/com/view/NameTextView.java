package com.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/18 0018.
 */

public class NameTextView extends LinearLayout {
    private final String NAME_SPACE = "http://schemas.android.com/apk/res/android";
    private final String ATTR_TEXT_COLOR = "textColor";
    private final String ATTR_TEXT_SIZE = "textSize";
    private final String ATTR_MAX_LINES = "maxLines";

    private final int DEFAULT_COLOR = 0x88000000;

    private Context mContext;
    private int mTextColor, mTextSize, mMaxLines;

    private String mText = "";// 要写入的文本

    private int mWidth;// 控件宽度

    private List<TextView> mChildViews;

    private boolean canDraw = false;

    public NameTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        if (attrs != null) {
            mMaxLines = attrs.getAttributeIntValue(NAME_SPACE, ATTR_MAX_LINES, 2);
            mTextColor = attrs.getAttributeIntValue(NAME_SPACE, ATTR_TEXT_COLOR, DEFAULT_COLOR);
            String size = attrs.getAttributeValue(NAME_SPACE, ATTR_TEXT_SIZE);
            if (TextUtils.isEmpty(size)) {
                mTextSize = 12;
            } else {
                mTextSize = Integer.parseInt(size.substring(0, size.lastIndexOf(".")));
            }
        }

        initSelf();
        initView();
    }

    private void initSelf() {
        setOrientation(VERTICAL);
        setWillNotDraw(true);
    }

    private void initView() {
        mChildViews = new ArrayList<>();
        for (int i = 0; i < mMaxLines; i++) {
            TextView v = createChildTextView();
            mChildViews.add(v);
            addView(v);
        }
    }

    /**
     * 构建子的TextView
     */
    private TextView createChildTextView() {
        TextView v = new TextView(mContext);
        v.setTextColor(mTextColor);
        v.setTextSize(mTextSize);
        v.setMaxLines(1);
        v.setSingleLine();
        v.setEllipsize(TextUtils.TruncateAt.END);
        v.setGravity(Gravity.CENTER_VERTICAL);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(params);

        return v;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canDraw) {
            setContent();
            canDraw = false;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w - getPaddingLeft() - getPaddingRight();
    }

    /**
     * set the content
     *
     * @param text content
     */
    @SuppressLint("NewApi")
    public void setText(@NonNull String text) {
        if (TextUtils.isEmpty(text) || this.mText.equals(text)) return;
        this.mText = text.trim();
        canDraw = true;
        invalidate();
    }

    /**
     * @param text content
     * @param line content-line
     */
    @SuppressLint("NewApi")
    public void setText(@NonNull String text, int line) {
        if (TextUtils.isEmpty(text) || this.mText.equals(text)) return;
        this.mMaxLines = line;
        this.mText = text.trim();
        canDraw = true;
        invalidate();
    }

    /**
     * 将内容设置到布局中
     */
    private void setContent() {
        Paint paint = mChildViews.get(0).getPaint();
        int start = 0;

        for (int i = 0; i < mMaxLines; i++) {
            TextView v = mChildViews.get(i);

            String str;
            if (i == mMaxLines - 1) {
                str = mText.substring(start);
            } else {
                int count = paint.breakText(mText, start, mText.length(), true, mWidth, null);
                str = mText.substring(start, start + count);
                start += count;
            }
            Log.d("NameTextView", "i=" + i + "=====" + str);
            v.setText(str);
            if (start >= mText.length()) break;
        }
    }
}
