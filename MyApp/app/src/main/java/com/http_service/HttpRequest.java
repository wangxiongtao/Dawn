package com.http_service;

import android.text.TextUtils;

import com.dawn.http.request.LoginRequest;
import com.http_service.download.DownLoadRequest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/10/21.
 */

public abstract class HttpRequest implements OnTokenErrorListener {
    public static final int GET = 1;//GET POST DOWNLOAD UPLOAD
    public static final int POST = 2;//GET POST DOWNLOAD UPLOAD
    public static final int DOWNLOAD = 3;//GET POST DOWNLOAD UPLOAD
    public static final int UPLOAD = 4;//GET POST DOWNLOAD UPLOAD
    private int tag;
    private String url;
    private String token = "http";


    public HttpRequest(int tag) {
        this.tag = tag;
    }

    public HttpRequest(int tag, String url) {
        this(tag);
        this.url = url;
    }

    public int getTag() {
        return tag;
    }


    public void doRequest(HttpCallBack callBack) {
        HttpMananger.getInstance(url).doPostRequest(this, callBack);
    }

    public void doRequest(@RequestType int type, HttpCallBack callBack) {
        switch (type) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                HttpMananger.getInstance(url).doDownLoadFile((DownLoadRequest) this, callBack);
                break;
            case 3:
                break;

        }

    }

    /**
     * 遍历该类下所有属性封装成参数map
     * 这里只对参数做非空判断
     * 如果有一些特殊判断请重写此方法，可以参考
     *
     * @return 请求参数map
     */
    public HashMap<String, String> getParamMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                String type = Modifier.toString(field.getModifiers());
                if ("public".equals(type)) {
                    String name = field.getName();
                    Object value = field.get(this);
                    if (value != null && !TextUtils.isEmpty(value.toString())) {
                        hashMap.put(name, value.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        hashMap.put("token", token);
        return hashMap;
    }

    @Override
    public void OnTokenError(HttpCallBack callBack) {
        LoginRequest request = new LoginRequest(1);
//        LoginRequest request=new LoginRequest(1);
//        request.doRequest(new HttpCallBack() {
//            @Override
//            public void onHttpStart(int tag) {
//
//            }
//
//            @Override
//            public void onHttpSuccess(String response, int tag) {
//                token="myToken";
//                doRequest(callBack);
//            }
//
//            @Override
//            public void onHttpFail(int tag) {
//
//            }
//        });
    }
}
