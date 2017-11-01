package com.util;

import android.util.Base64;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Created by Administrator on 2017/10/31.
 */

public class NativeUtil {
    static {
        System.loadLibrary("dawn");
    }

    public static native String getStringC();

    public static native String myEncrypt(String content);

    public static native String myDecrypt(String content);


}
