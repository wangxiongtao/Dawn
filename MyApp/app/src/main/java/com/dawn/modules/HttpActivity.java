package com.dawn.modules;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dawn.R;
import com.dawn.base.BaseActivity;
import com.dawn.http.request.LoginRequest;
import com.http_service.HttpRequest;
import com.http_service.RequestType;
import com.http_service.download.DownLoadRequest;
import com.util.LogUtil;

import java.io.File;

public class HttpActivity extends BaseActivity {
    private TextView textView;
    private  MyHandler handler;


    public static class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }





    @Override
    protected int getLayoutId() {
        return R.layout.activity_http;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        textView=findViewById(R.id.tv);
        textView.setText(String.format(""));

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }
    public void onClick(View v){
        if(toLoginActivity(new OnBackLoginActivityListener() {
            @Override
            public void onBackLoginActivity() {

            }
        })){

        };


        LoginRequest request=new LoginRequest(10);
        request.mobilePhone="17600801534";
        request.vCode="8888";
        request.doRequest(this);
        request.doRequest(HttpRequest.POST,this);

        ActivityCompat.requestPermissions(HttpActivity.this, new String[]{android
                .Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);























//        Log.i("aaa","====onClick======>");
//        MyRequest request=new MyRequest(0);
//        request.id="0";
//        request.name="0";
//        request.age=0;
//        request.doRequest(this);
//        MyRequest request1=new MyRequest(1);
//        request1.id="1";
//        request1.name="1";
//        request1.age=1;
//        request1.doRequest(this);
//        LoginRequest request2=new LoginRequest(2);
//        request2.name="login2";
//        request2.doRequest(this);
//        LoginRequest request3=new LoginRequest(3);
//        request3.name="login3";
//        request3.doRequest(this);
//        LoginRequest request4=new LoginRequest(4);
//        request4.name="login4";
//        request4.doRequest(this);
//        LoginRequest request1=new LoginRequest(1);
//        request1.name="login";
//        request1.doRequest(this);
    }

    @Override
    public void onHttpStart(int tag) {
        super.onHttpStart(tag);
        textView.setText("请求开始");
    }

    @Override
    public void onHttpSuccess(String response, int tag) {
        super.onHttpSuccess(response, tag);
        Toast.makeText(this,response,0).show();
        textView.setText(response);

//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });

    }

    @Override
    public void onProgress(long total, long current) {
        super.onProgress(total, current);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText("进度"+(new Float(current)/total)*100);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        LogUtil.i("======onRequestPermissionsResult====>");
        switch (requestCode) {
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //创建文件夹
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

                        DownLoadRequest request=new DownLoadRequest(2);
                        request.desFilePath= Environment.getExternalStorageDirectory()+ File.separator+"test";
                        request.fileName="kaochong";

                        File file = new File(request.desFilePath);
//                        if (!file.exists()) {
//                            LogUtil.i("======创建====>" + file.mkdirs());
//
//                        }
                        request.doRequest(2,this);
                    }
                    break;
                }
        }
    }
}
