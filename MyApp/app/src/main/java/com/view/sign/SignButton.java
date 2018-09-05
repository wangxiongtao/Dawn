package com.view.sign;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dawn.R;

/**
 * Created by Administrator on 2018/4/10 0010.
 */

public class SignButton extends LinearLayout {
    private ImageView[] ivs;
    private int n=0;
    private MyAnimationListener listener;
    private AlphaAnimation animation;
    private RelativeLayout signLayout;
    private TextView signTv;
    private boolean isStop;

    public SignButton(Context context) {
        super(context);
        init();
    }

    public SignButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SignButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){

        View view= LayoutInflater.from(getContext()).inflate(R.layout.sign_btn_layout,this,true);
        ImageView iv0=view.findViewById(R.id.sign_start_iv0);
        ImageView iv1=view.findViewById(R.id.sign_start_iv1);
        ImageView iv2=view.findViewById(R.id.sign_start_iv2);
        ImageView iv3=view.findViewById(R.id.sign_start_iv3);
        ImageView iv4=view.findViewById(R.id.sign_start_iv4);
        signLayout=view.findViewById(R.id.sign_btn_layout);
        signTv=view.findViewById(R.id.sign_btn_tv);
        ivs=new ImageView[]{iv0,iv1,iv2,iv3,iv4};
        listener=new MyAnimationListener();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimation();
                setIsSign(true);

            }
        });

        startAnimation(ivs[n]);
    }



    private void startAnimation(ImageView iv){
        if(isStop){
            return;
        }

        animation=new AlphaAnimation(1,0);
        animation.setDuration(500);
        animation.setAnimationListener(listener);
        iv.startAnimation(animation);
    }
    private  void stopAnimation(){
        isStop=true;
        for (int i=0;i<ivs.length;i++){
            ivs[i].setVisibility(GONE);
        }
    }

    public void setIsSign(boolean isSign){
        if(isSign){//已经签到了
            signLayout.setBackgroundResource(R.drawable.signed_bg);
            signTv.setTextColor(Color.parseColor("#999999"));
            Drawable left = getResources().getDrawable(R.drawable.sign);
            signTv.setCompoundDrawablesWithIntrinsicBounds(left, null , null, null);
        }else {
            signLayout.setBackgroundResource(R.drawable.nosign_bg);
            signTv.setTextColor(Color.parseColor("#998860"));
            Drawable left = getResources().getDrawable(R.drawable.sign);
            signTv.setCompoundDrawablesWithIntrinsicBounds(left, null , null, null);
        }
    }






    class MyAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            n++;
            if(n>=ivs.length){
                n=0;
            }
            ivs[n].setVisibility(GONE);

            startAnimation(ivs[n]);

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }







}
