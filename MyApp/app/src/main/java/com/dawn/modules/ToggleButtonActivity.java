package com.dawn.modules;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.dawn.R;
import com.util.LogUtil;
import com.util.ToastUtil;
import com.view.SwitchButton;

public class ToggleButtonActivity extends AppCompatActivity {
    private Switch aSwitch;
    private SwitchButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);
        aSwitch=findViewById(R.id.switch1);
        button=findViewById(R.id.switch3);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                LogUtil.i("==isChecked=======>"+isChecked);
            }
        });
        button.setOnCheckListener(new SwitchButton.OnCheckListener() {
            @Override
            public void onCheck(boolean isCheckAtLeft) {
                if(isCheckAtLeft){
                    ToastUtil.showShort(getApplicationContext(),"左边选中");
                }else {
                    ToastUtil.showShort(getApplicationContext(),"右边选中");
                }
            }
        });
    }
}
