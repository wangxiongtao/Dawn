package com.dawn.modules;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.dawn.R;
import com.util.LogUtil;
import com.util.ToastUtil;

public class ServiceTestActivity extends AppCompatActivity {
    TextView openStartService;
    TextView closeStartService;

    TextView openbindService;
    TextView closebindService;
    private ServiceConnection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        openStartService=findViewById(R.id.open_start_service);
        closeStartService=findViewById(R.id.close_start_service);
        openbindService=findViewById(R.id.open_bind_service);
        closebindService=findViewById(R.id.close_unbind_service);
        conn=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

                AliveService service1=((AliveService.MyBinder) service).getService();
                ToastUtil.showShort(ServiceTestActivity.this,"onServiceConnected========="+service1);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                LogUtil.i("======onServiceDisconnected========>");
                ToastUtil.showShort(ServiceTestActivity.this,"onServiceDisconnected");
            }
        };
        setListener();





    }

    @Override
    protected void onResume() {
        super.onResume();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                return false;
            }
        });
    }

    private void setListener(){
        openStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ToastUtil.showShort(v.getContext(),"openStartService");
                startService(new Intent(v.getContext(),AliveService.class));
            }
        });
        closeStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(v.getContext(),AliveService.class));
            }
        });
        openbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ToastUtil.showShort(v.getContext(),"openStartService");
                Intent intent = new Intent(v.getContext(), AliveService.class);
                intent.putExtra("from", "ActivityA");
                bindService(intent, conn, BIND_AUTO_CREATE);
            }
        });
        closebindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
            }
        });
    }

}
