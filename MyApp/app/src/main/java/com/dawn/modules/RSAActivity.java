package com.dawn.modules;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dawn.R;
import com.util.NativeUtil;

public class RSAActivity extends AppCompatActivity {

    /* 密钥内容 base64 code */
    private static String PUCLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqEbh14KvJ1UA+LJzA1IfLowlH" +
            "gEJDi/4Ppkq6XF/Qe0u4JM4/bqLWfGp88I6uITz7/VOT5EED8fv5kVEGdaxgt2NR" +
            "gEJsbjqveu7hZ9UK/f4lwjYy4Q58/r4tUgbXTs/AXCQRz4A7OO7UjNxRJPxfC3Aw" +
            "qzhH9sHCEUUZoEUoRwIDAQAB";
    private static String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKoRuHXgq8nVQD4s" +
            "nMDUh8ujCUeAQkOL/g+mSrpcX9B7S7gkzj9uotZ8anzwjq4hPPv9U5PkQQPx+/mR" +
            "UQZ1rGC3Y1GAQmxuOq967uFn1Qr9/iXCNjLhDnz+vi1SBtdOz8BcJBHPgDs47tSM" +
            "3FEk/F8LcDCrOEf2wcIRRRmgRShHAgMBAAECgYEAjxy8Wc2HIh/moKtP+WCfKTh3" +
            "/YgrusWaNLcd2TcUlc67SCkIug4yz0UBI0QW/OcRd4eUhjYkk9pUzI2BXms1cwqJ" +
            "lshIgiOllElCp3gmjvY9sIoU8leictnpEsMXOUpnyBuZl5NKJXnxg1hCoOot4PJF" +
            "cXUj31Edi9EQbhYjRJkCQQDTvmi/DeSu5CLeiJ42eDtg+n5P5weZWlEuErMfD//8" +
            "A+54Rv/QDCAwNjs+Z32C1EuLr4g+fKVorCoL/rPvyiBzAkEAzZ13dXAHcVExV11G" +
            "4SPPzMlRyOAGP5cxl7tV+O4ta3VoQEI7YH7GIJvUy1ujeB/dKzFQrMRz3bteQMsO" +
            "A4wH3QJASyrAAnrLIK7KFheHmqyJ375s0q6gCvd99A4dWjyS0gMPR9FkhJWZY6QM" +
            "2fVhH+1/OAJDKnOTQJpFfuaXN9uYMwJAc28ZFtRbSVH06oBSf6k0S1sm0Ch9OYwv" +
            "amjg/kzxMOgMLC9C2IyzvLDfyX9cCd+RsmMQUL5F8lDzvFqDNpiR/QJAZZQGI8bW" +
            "vCN2f9PVMR1xWFo3Sx3IJxFbV2le5opNwzPI8qYdO0MxmI0IRw5IteFTXXwf3BI2" +
            "sdVzuPhqDLcKBg==";















    String source;
    String sign;
    private EditText editText;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsa);
        editText= (EditText) findViewById(R.id.content_ed);
        tv= (TextView) findViewById(R.id.result_tv);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.jiami_btn:
                 source = editText.getText().toString().trim();
                editText.setText(NativeUtil.myEncrypt(source));

                break;
            case R.id.jiemi_btn:
                String encryptContent = editText.getText().toString().trim();
                tv.setText(NativeUtil.myDecrypt(encryptContent));
//                tv.setText(RSAUtil.decrypt(PRIVATE_KEY,encryptContent));
                break;

        }
    }
}
