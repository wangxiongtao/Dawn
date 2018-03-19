package com.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import com.dawn.R;
import com.util.LogUtil;


/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class InputPwdLayout2 extends LinearLayout {
    private SquareEditext[] editTexts;
    private TextWatcher[] textWatchers;
    private int currentIndex;



    public InputPwdLayout2(Context context) {
        super(context);
        init();
    }

    public InputPwdLayout2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InputPwdLayout2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        textWatchers=new TextWatcher[7];
        View view= LayoutInflater.from(getContext()).inflate( R.layout.input_pwd_layout,this,true);
        SquareEditext editText0=view.findViewById(R.id.input_pwd_et0);
        SquareEditext editText1=view.findViewById(R.id.input_pwd_et1);
        SquareEditext editText2=view.findViewById(R.id.input_pwd_et2);
        SquareEditext editText3=view.findViewById(R.id.input_pwd_et3);
        SquareEditext editText4=view.findViewById(R.id.input_pwd_et4);
        SquareEditext editText5=view.findViewById(R.id.input_pwd_et5);
        SquareEditext editText6=view.findViewById(R.id.input_pwd_et6);
        editTexts=new SquareEditext[]{editText0,editText1,editText2,editText3,editText4,editText5,editText6};
        initListener();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                editText0.requestFocus();
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
        setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode==KeyEvent.KEYCODE_DEL){
                    if(currentIndex==0){
                        return false;
                    }

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            LogUtil.i("====>当前焦点是"+currentIndex+"准备情况的位子是"+(currentIndex-1));
//                        editTexts[i-1].removeTextChangedListener(textWatchers[i-1]);
                            editTexts[currentIndex-1].setText("");
                            editTexts[currentIndex-1].requestFocus();
//                        editTexts[i-1].addTextChangedListener(textWatchers[i-1]);
                            currentIndex--;
                        }
                    },200);

                }


                return false;
            }
        });
    }

    private void initListener(){

        for (int i=0;i<7;i++){
            SquareEditext editText=editTexts[i];
//            editText.setOnKeyListener(new MyKeyListener(i));
            TextWatcher textWatcher=new MyTextWatcher(i);
            editText.addTextChangedListener(textWatcher);
            textWatchers[i]=textWatcher;


        }
    }

    private class MyTextWatcher implements TextWatcher{
        int i;

        public MyTextWatcher(int i) {
            this.i = i;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            LogUtil.i("======afterTextChanged==>");
            if(i==6){
                //输入完成
//                editTexts[i].removeTextChangedListener(this);
//                editTexts[i].setText(".");
//                editTexts[i].setSelection(1);
//                editTexts[i].addTextChangedListener(this);

                return;
            }
//            editTexts[i+1].requestFocus();
            currentIndex=i+1;

        }
    }

    private class MyKeyListener implements OnKeyListener{
        int i;

        public MyKeyListener(int i) {
//            if(i==5){
//                i=6;
//            }
            this.i = i;
        }

        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if(keyCode==KeyEvent.KEYCODE_DEL){
                if(i==0){
                    return false;
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.i("====>当前焦点是"+i+"准备情况的位子是"+(i-1));
//                        editTexts[i-1].removeTextChangedListener(textWatchers[i-1]);
                        editTexts[i-1].setText("");
                        editTexts[i-1].requestFocus();
//                        editTexts[i-1].addTextChangedListener(textWatchers[i-1]);
                    }
                },200);

            }


            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        LogUtil.i("=keyCode=======>"+keyCode);



        return super.onKeyDown(keyCode, event);
    }
}
