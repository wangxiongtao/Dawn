package com.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.dawn.R;
import com.util.LogUtil;
import com.util.ToastUtil;


/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class InputPwdLayout extends LinearLayout {
    private SquareEditext[] editTexts;

    private StringBuilder pwdResult;
    private int totalCount=6;
    private int realCount=5;



    public InputPwdLayout(Context context) {
        super(context);
        init();
    }

    public InputPwdLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InputPwdLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        pwdResult=new StringBuilder();
//        View view= LayoutInflater.from(getContext()).inflate( R.layout.input_pwd_layout,this,true);
        View view= View.inflate(getContext(), R.layout.input_pwd_layout1,null);
//        SquareEditext editText0=view.findViewById(R.id.input_pwd_et0);
//        SquareEditext editText1=view.findViewById(R.id.input_pwd_et1);
//        SquareEditext editText2=view.findViewById(R.id.input_pwd_et2);
//        SquareEditext editText3=view.findViewById(R.id.input_pwd_et3);
//        SquareEditext editText4=view.findViewById(R.id.input_pwd_et4);
//        SquareEditext editText5=view.findViewById(R.id.input_pwd_et5);
//        SquareEditext editText6=view.findViewById(R.id.input_pwd_et6);
//        editTexts=new SquareEditext[]{editText0,editText1,editText2,editText3,editText4,editText5,editText6};
//        initListener();
//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//            }
//        });
        addView(view);
//        addView(view,new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    private void initListener(){

        for (int i=0;i<totalCount+1;i++){
            SquareEditext editText=editTexts[i];
            editText.setOnKeyListener(new MyKeyListener(i));
            TextWatcher textWatcher=new MyTextWatcher(i);
            editText.addTextChangedListener(textWatcher);



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
            LogUtil.i("======afterTextChanged==>"+s.toString());
            if(i==totalCount){

                return;
            }

            if(i==realCount&&!TextUtils.isEmpty(s.toString())){
                //输入完成
                LogUtil.i("===pwd======>"+getPwd());
                ToastUtil.show(getContext(),getPwd(),0);
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        clearAll();
//                        LogUtil.i("===pwd==输入错误====>");
//                    }
//                },3000);

            }
            editTexts[i+1].setFocusable(true);
            editTexts[i+1].requestFocus();

        }
    }

    private class MyKeyListener implements OnKeyListener{
        int i;

        public MyKeyListener(int i) {
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
                        editTexts[i-1].setText("");
                        editTexts[i-1].requestFocus();
                    }
                },100);

            }


            return false;
        }
    }
    public void clearAll(){
        for (int i=0;i<totalCount+1;i++){
            SquareEditext editText=editTexts[i];
            editText.setText("");
            if(i==0){
                editText.requestFocus();
            }else {
                editText.setFocusable(false);
            }
        }


    }
    private  String getPwd(){
        pwdResult.setLength(0);
        for (int i=0;i<realCount+1;i++){
            SquareEditext editText=editTexts[i];
            pwdResult.append(editText.getText().toString());
        }
        return pwdResult.toString();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }


}
