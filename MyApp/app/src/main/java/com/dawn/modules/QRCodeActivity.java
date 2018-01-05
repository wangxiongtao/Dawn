package com.dawn.modules;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dawn.R;
import com.dawn.base.BaseActivity;
import com.google.zxing.WriterException;
import com.third_party.zxing.activity.CaptureActivity;
import com.third_party.zxing.encoding.EncodingHandler;

public class QRCodeActivity extends BaseActivity  {

    Button openQrCodeScan;

    EditText text;

    Button CreateQrCode;

    ImageView QrCode;

    TextView qrCodeText;
    //打开扫描界面请求码
    private int REQUEST_CODE = 0x01;
    //扫描成功返回码
    private int RESULT_OK = 0xA1;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_qrcode;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        text=findViewById(R.id.text);
        QrCode=findViewById(R.id.QrCode);
        qrCodeText=findViewById(R.id.qrCodeText);

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.openQrCodeScan:
                //打开二维码扫描界面
//                if(CommonUtil.isCameraCanUse()){
                    Intent intent = new Intent(QRCodeActivity.this, CaptureActivity.class);
                    startActivityForResult(intent, REQUEST_CODE);
//                }else{
//                    Toast.makeText(this,"请打开此应用的摄像头权限！",Toast.LENGTH_SHORT).show();
//                }
                break;
            case R.id.CreateQrCode:
                try {
                    //获取输入的文本信息
                    String str = text.getText().toString().trim();
                    if(str != null && !"".equals(str.trim())){
                        //根据输入的文本生成对应的二维码并且显示出来
                        Bitmap mBitmap = EncodingHandler.createQRCode(text.getText().toString(), 500);
                        if(mBitmap != null){
                            Toast.makeText(this,"二维码生成成功！",Toast.LENGTH_SHORT).show();
                            QrCode.setImageBitmap(mBitmap);
                        }
                    }else{
                        Toast.makeText(this,"文本信息不能为空！",Toast.LENGTH_SHORT).show();
                    }
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { //RESULT_OK = -1
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("qr_scan_result");
            //将扫描出的信息显示出来
            qrCodeText.setText(scanResult);
        }
    }
}
