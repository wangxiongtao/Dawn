package com.dawn.modules;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Chronometer;

import com.dawn.R;
import com.dawn.modules.adapter.TiKuAdapter;
import com.dawn.modules.fragment.ShortAnswerFargment;
import com.dawn.modules.fragment.SingleChoiceFragment;
import com.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;

public class TiKuActivity extends AppCompatActivity {
    ViewPager viewPager;
    TiKuAdapter adapter;
    List<Fragment>fragmentList;
    CountdownView countdownView;
   Chronometer ch;
   long startTime=3605*1000;
//   long startTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ti_ku);
        viewPager=findViewById(R.id.tiku_vp);
        ch=findViewById(R.id.timer);
        fragmentList=new ArrayList<>();
        fragmentList.add(new SingleChoiceFragment());
        fragmentList.add(new SingleChoiceFragment());
        fragmentList.add(new ShortAnswerFargment());
        fragmentList.add(new SingleChoiceFragment());
        adapter=new TiKuAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        startTime=SystemClock.elapsedRealtime()-ch.getBase();
        ch.stop();
        ToastUtil.showShort(this,getChronometerSeconds(ch));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ch.setBase(SystemClock.elapsedRealtime()-startTime);
        ch.start();
    }



    public  static String getChronometerSeconds(Chronometer cmt) {
        int totalss = 0;
        String string = cmt.getText().toString();
        if(string.length()==7){

            String[] split = string.split(":");
            String string2 = split[0];
            int hour = Integer.parseInt(string2);
            int Hours =hour*3600;
            String string3 = split[1];
            int min = Integer.parseInt(string3);
            int Mins =min*60;
            int  SS =Integer.parseInt(split[2]);
            totalss = Hours+Mins+SS;
            return String.valueOf(totalss);
        }

        else if(string.length()==5){

            String[] split = string.split(":");
            String string3 = split[0];
            int min = Integer.parseInt(string3);
            int Mins =min*60;
            int  SS =Integer.parseInt(split[1]);

            totalss =Mins+SS;
            return String.valueOf(totalss);
        }
        return String.valueOf(totalss);


    }

}
