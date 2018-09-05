package com.dawn.modules;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dawn.R;
import com.util.ToastUtil;

public class PlayAudioActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_audio);
    }

    public void onClick(View view){
//        String uri="android.resource://" + getPackageName() +"/";
//        uri+=R.raw.refundorder;
//        Uri no=Uri.parse(uri);
//        RingtoneManager.getRingtone(this, no).play();
        ToastUtil.showShort(view.getContext(),"京东到家\r\n"+"美团外卖\r\n"+"1234");

    }
}
