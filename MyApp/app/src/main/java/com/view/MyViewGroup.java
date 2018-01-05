package com.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/5.
 */

public class MyViewGroup extends ViewGroup {
    private int line=0;//item的行
    int col=0;//item的列
    int cw;//item 的宽度
    int ch;//item 的宽度
    int sumChildWidth;
    int sumChildHeight;
    int leftWidth=50;
    int topWidth=0;
    String[] arr={"前些日子","重温了早已忘却的JavaEE","的一","些知识点，","然后又捣鼓了P","ython，《Chrome扩};","然而之后发现And,","roid好多东西又淡","忘了，看来自己的记性真是越来越差了","总是烫剩",
   "前些日子","重温了早,","已忘却的JavaEE","的一","些知识点，","然后又捣鼓了Python，《Chrome扩};","然而之后发现And,","roid好多东西又淡","忘了，看来自己的记性真是越来越差了","总是烫剩","wsd","1112222222233333333334444"};
    public OnKeyListener listener=new OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            // 这两个条件必须同时成立，如果仅仅用了enter判断，就会执行两次
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {

                addView(getEditText());
                // 执行发送消息等操作
                return true;
            }
            return false;
        }
    };
    private List<View>viewList=new ArrayList<>();
    public MyViewGroup(Context context) {
        super(context);
        init();
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
//        for (int i = 0; i < 22; i++) {
//            TextView tv = new TextView(getContext());
//            tv.setBackgroundColor(Color.parseColor("#ff6600"));
//            tv.setText(arr[i]);
//            MarginLayoutParams lp= (MarginLayoutParams) generateDefaultLayoutParams();
////            lp.leftMargin=150;
////            lp.topMargin=150;
//            tv.setLayoutParams(lp);
//
//            viewList.add(tv);
//        }
        EditText editText=new EditText(getContext());
        editText.setOnKeyListener(listener);
        addView(editText);
//        TextView textView=getTetxView();
//        textView.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showShort(getContext(),"click");
//                addView(getTetxView());
////                removeAllViews();
//            }
//        });
//        addView(textView);


    }
    public EditText getEditText(){
        EditText editText=new EditText(getContext());
        editText.setOnKeyListener(listener);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        return editText;

    }
    public TextView getTetxView(){
        TextView tv=new TextView(getContext());
        tv.setText("wqedwqdsas");
        tv.setPadding(20,20,20,20);
        return tv;

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View child = this.getChildAt(i);
            this.measureChild(child, widthMeasureSpec, heightMeasureSpec);
//            int cw = child.getMeasuredWidth();
//            // int ch = child.getMeasuredHeight();
            MarginLayoutParams lp = (MarginLayoutParams) getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            //子View占据的高度
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        myLayout();

    }

    private void myLayout(){
        sumChildWidth=0;
        line=0;
        int w=getMeasuredWidth();
        for (int i=0;i<getChildCount();i++){
            View v=getChildAt(i);
            MarginLayoutParams lp = (MarginLayoutParams) v.getLayoutParams();
            cw=v.getMeasuredWidth();
            ch=v.getMeasuredHeight();
            int aaaa=v.getMeasuredHeight();
            sumChildWidth+=cw+leftWidth;
            if(sumChildWidth>w){//换行
//                leftWidth=50;
                topWidth=0;
                col=0;
                line++;
                sumChildWidth=cw+leftWidth;

            }
//            if(line==0){
//                leftWidth=0;
//                topWidth=0;
//            }else {
//                leftWidth=50;
//                topWidth=50;
//            }

//            sumChildHeight=line*ch+lp.topMargin;
            v.layout(sumChildWidth-cw, line*(ch)+topWidth*(line), sumChildWidth, (line+1)*ch+topWidth*(line));
            col++;

        }
    }


    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs)
    {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MyLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    public static class MyLayoutParams extends MarginLayoutParams {

        public MyLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public MyLayoutParams(int width, int height) {
            super(width, height);
        }

        public MyLayoutParams(LayoutParams lp) {
            super(lp);
        }
    }









    public void addViewList(List<View>list){
       for (int i=0;i<list.size();i++){
           addView(list.get(i));
       }
    }
}
