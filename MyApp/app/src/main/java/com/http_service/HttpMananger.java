package com.http_service;


import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;

import com.http_service.download.DownLoadRequest;
import com.util.LogUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Administrator on 2017/10/21.
 */

public class HttpMananger extends AbstractHttp {
    private static  HttpMananger httpMananger;
    private HttpRequest request;
    private String url;
    boolean b;

    private OkHttpClient okHttpClient;
    private Handler handler;
    private HttpMananger(String url){
        this.url=url;
        okHttpClient=getOkHttpClient();
        handler=new Handler();
    }
    public static HttpMananger getInstance(String url){
        if(httpMananger==null){
            httpMananger=new HttpMananger(url);
        }
        return httpMananger;
    }
    @Override
    public void doPostRequest(HttpRequest request,HttpCallBack callBack) {
        Log.e("aaa","===执行开始======>"+request+"=="+request.getTag()+"----------"+request.getParamMap());
        callBack.onHttpStart(10);
        try{
            FormBody.Builder builder=new FormBody.Builder();
            HashMap<String,String> map=request.getParamMap();
            for (Map.Entry<String,String> entry :map.entrySet()){
                builder.add(entry.getKey(),entry.getValue());
            }
            FormBody body=builder.build();
            Request myRequest=new Request.Builder().url(url).post(body).tag(request.getTag()).build();
            Call call=okHttpClient.newCall(myRequest);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    LogUtil.e("===onFailure=========>"+e.getMessage());

                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    String str=response.body().string();
                    int tag= (int) call.request().tag();
                    LogUtil.e("===onResponse=========>"+str);
                    LogUtil.e("===onResponse===tag======>"+tag);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onHttpSuccess(str,10);
                        }
                    });


                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void doGetRequest(HttpCallBack callBack) {

    }

    @Override
    public void doDownLoadFile(DownLoadRequest request, HttpCallBack callBack) {
        File parenFile=new File(request.desFilePath);
        if(!parenFile.exists()){
            parenFile.mkdirs();
        }
        final File file = new File(parenFile, request.fileName);
        if(file.exists()){
            file.delete();
        }
        Request myRequest = new Request.Builder().url(url).build();
        Call call=okHttpClient.newCall(myRequest);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len;
                FileOutputStream fos = null;
                try {
                    long total = response.body().contentLength();
                    long current = 0;
                    is = response.body().byteStream();
                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        current += len;
                        fos.write(buf, 0, len);
                        callBack.onProgress(total, current);
                    }
                    fos.flush();
                } catch (IOException e) {
                } finally {
                    try {
                        if (is != null) {
                            is.close();
                        }
                        if (fos != null) {
                            fos.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    @Override
    public void doUpLoadFile() {

    }

    @Override
    public boolean isCorrect(int code) {
        return true;
    }
    private class MyRun implements Runnable{
        private Long l1,l2;
        private HttpCallBack callBack;

        @Override
        public void run() {
            callBack.onProgress(l1,l2);
        }
    }
}
